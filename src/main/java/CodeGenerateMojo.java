import model.CodeGenConfig;
import model.GenConfig;
import model.ReplaceConfig;
import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author lipeng
 * @date 2020-02-18 18:45
 * @description
 **/

@Mojo(name = "generate", defaultPhase = LifecyclePhase.PACKAGE)
public class CodeGenerateMojo extends AbstractMojo {

    /**
     * Maven Project.
     */
    @Parameter(property = "project", required = true, readonly = true)
    private MavenProject project;

    /**
     * Location of the configuration file.
     */
    @Parameter(property = "code.generator.configurationFile",
            defaultValue = "${project.basedir}/src/main/resources/codeGeneratorConfig.json", required = true)
    private File configurationFile;

    /**
     * Output Directory.
     */
    @Parameter(property = "code.generator.outputDirectory",
            defaultValue = "${project.build.directory}/generated-sources/code-generator", required = true)
    private File outputDirectory;

    /**
     * skip generate.
     */
    @Parameter(property = "code.generator.skip",
            defaultValue = "false", required = true)
    private boolean skip;

    private List<ReplaceConfig> replaceConfigList;
    private String author;
    private String date;


    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (skip) {
            System.out.println("跳过代码生成");
            return;
        }
        try {
            String codeGenConfigString = FileUtils.readFileToString(configurationFile, Charset.defaultCharset());
            CodeGenConfig codeGenConfig = JsonConverter.parse(codeGenConfigString, CodeGenConfig.class);

            System.out.println("读取到的配置为：" + codeGenConfigString);
            System.out.println("codeGenConfig.getSrcPath()：" + codeGenConfig.getSrcPath());
            author = codeGenConfig.getAuthor();
            date = codeGenConfig.getDate();
            List<GenConfig> genConfigList = codeGenConfig.getGenConfig();
            replaceConfigList = codeGenConfig.getReplaceConfig();
            genConfigList.forEach(new Consumer<GenConfig>() {
                @Override
                public void accept(GenConfig genConfig) {
                    File srcPath = new File(codeGenConfig.getSrcPath() + genConfig.getSrcPath());
                    if (srcPath.exists()) {
                        handleFile(srcPath, codeGenConfig.getDesPath() + genConfig.getDesPath());
                    } else {
                        System.out.println("无此目录");
                    }
                }
            });
        } catch (IOException e) {
            throw new MojoExecutionException("配置文件读取错误");
        }
    }


    public void execute(File configurationFile) throws MojoExecutionException, MojoFailureException {
        if (skip) {
            System.out.println("跳过代码生成");
            return;
        }
        try {
            String codeGenConfigString = FileUtils.readFileToString(configurationFile, Charset.defaultCharset());
            CodeGenConfig codeGenConfig = JsonConverter.parse(codeGenConfigString, CodeGenConfig.class);

            System.out.println("读取到的配置为：" + codeGenConfigString);
            System.out.println("codeGenConfig.getSrcPath()：" + codeGenConfig.getSrcPath());
            author = codeGenConfig.getAuthor();
            date = codeGenConfig.getDate();
            List<GenConfig> genConfigList = codeGenConfig.getGenConfig();
            replaceConfigList = codeGenConfig.getReplaceConfig();
            genConfigList.forEach(new Consumer<GenConfig>() {
                @Override
                public void accept(GenConfig genConfig) {
                    File srcPath = new File(codeGenConfig.getSrcPath() + genConfig.getSrcPath());
                    if (srcPath.exists()) {
                        handleFile(srcPath, codeGenConfig.getDesPath() + genConfig.getDesPath());
                    } else {
                        System.out.println("无此目录");
                    }
                }
            });
        } catch (IOException e) {
            throw new MojoExecutionException("配置文件读取错误");
        }
    }

    private void handleFile(File file, String desPath) {
        if (file.isDirectory()) {
            File[] fileArr = file.listFiles();
            if (fileArr != null && fileArr.length > 0) {
                for (File innerFile : fileArr) {
                    if (file.getName().contains("-ignore")) {
                        handleFile(innerFile, desPath);
                    } else {
                        handleFile(innerFile, desPath + file.getName() + "/");
                    }
                }
            }
        } else if (file.isFile()) {
            if (!file.getName().startsWith(".")) {
                System.out.println(file.getPath() + "是文件");
                try {
                    String readFile = FileUtils.readFileToString(file, Charset.defaultCharset());
                    String pkgPath = desPath.substring(desPath.indexOf("cc/linkedme"), desPath.length() - 1).replace("/", ".");
                    readFile = readFile.replace("${author}", author);
                    readFile = readFile.replace("${date}", date);
                    readFile = readFile.replace("${pkg_name}", pkgPath);

                    String newFileName = file.getName();
                    for (ReplaceConfig replaceConfig : replaceConfigList) {
                        readFile = readFile.replace(replaceConfig.getOldString(), replaceConfig.getNewString());
                        newFileName = newFileName.replace(replaceConfig.getOldString(), replaceConfig.getNewString());
                    }
                    try {
                        if (!new File(desPath).exists()) {
                            FileUtils.forceMkdir(new File(desPath));
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("开始替换文件：" + new File(desPath + newFileName).getAbsolutePath());
                    FileUtils.writeStringToFile(new File(desPath + newFileName), readFile, Charset.defaultCharset());
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("文件读取错误，错误的文件：" + file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) throws MojoFailureException, MojoExecutionException {
        CodeGenerateMojo codeGenerateMojo = new CodeGenerateMojo();
        File file = new File("src/main/resources/codeGeneratorConfig.json");
        codeGenerateMojo.execute(file);
    }


}
