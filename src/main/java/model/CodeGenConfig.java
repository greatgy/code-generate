package model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

/**
 * @author lipeng
 * @date 2020-02-18 23:29
 * @description
 **/
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CodeGenConfig {
    private String author;
    private String date;
    private String srcPath;
    private String desPath;
    private String pkgPath;
    private List<GenConfig> genConfig;
    private List<ReplaceConfig> replaceConfig;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getDesPath() {
        return desPath;
    }

    public void setDesPath(String desPath) {
        this.desPath = desPath;
    }

    public List<GenConfig> getGenConfig() {
        return genConfig;
    }

    public void setGenConfig(List<GenConfig> genConfig) {
        this.genConfig = genConfig;
    }

    public List<ReplaceConfig> getReplaceConfig() {
        return replaceConfig;
    }

    public void setReplaceConfig(List<ReplaceConfig> replaceConfig) {
        this.replaceConfig = replaceConfig;
    }

    public String getPkgPath() {
        return pkgPath;
    }

    public void setPkgPath(String pkgPath) {
        this.pkgPath = pkgPath;
    }
}
