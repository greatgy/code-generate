## 代码生成配置说明

### 配置文件声明

codeGeneratorConfig.json 配置如下，该配置文件用于配置需要替换的字符串

> ！！！ 需要特别注意！！！在mybatis生成PO时，生成的类需要加PO  

示例：
```xml
 <table tableName="oauth_token" domainObjectName="OauthTokenPO">
            <!-- 适用于自增主键，自动生成SelectKey，参见：https://mybatis.org/generator/configreference/generatedKey.html -->
            <generatedKey column="id" sqlStatement="SELECT LAST_INSERT_ID()" identity="true" type="post"/>
        </table>
```

```json
{
  "author": "lipeng",  // 作者
  "date": "2020-08-17 11:40",  // 生成日期
  "src_path": "/Users/LinkedME06/Downloads/code-generate/", // 源码位置
  "des_path": "/Users/LinkedME06/IdeaProjects/active-op/", // 工程路径
  "pkg_path": "cc.linkedme.active.op",//包名
  "replace_config": [ // 需要替换的字符串位置，目前只配置了以下可替换的字符串
    {
      "old_string": "${AaBb}",
      "new_string": "OauthToken"
    },
    {
      "old_string": "${aaBb}",
      "new_string": "oauthToken"
    },
    {
      "old_string": "${aa_bb}",
      "new_string": "oauth_token"
    },
    {
      "old_string": "${AA_BB}",
      "new_string": "OAUTH_TOKEN"
    }
  ],
  "gen_config": [ // 不同的module模块
    {
      "src_path": "web-ignore",
      "des_path": "op-web/src/main/java/cc/linkedme/active/op/web/"
    },
    {
      "src_path": "api-ignore",
      "des_path": "op-service-api/src/main/java/cc/linkedme/active/op/"
    },
    {
      "src_path": "impl-ignore",
      "des_path": "op-service/src/main/java/cc/linkedme/active/op/service/"
    }
  ]
}
```

### maven配置

与codeGeneratorConfig.json文件的module模块

```xml
<build>
        <plugins>
             <plugin>
                  <groupId>cc.linkedme</groupId>
                  <artifactId>code-generate</artifactId>
                  <version>1.0-SNAPSHOT</version>
                  <configuration>
                      <skip>false</skip>
                  </configuration>
            
                  <executions>
                      <execution>
                          <id>Code Generate</id>
                          <goals>
                              <goal>generate</goal>
                          </goals>
                      </execution>
                  </executions>
              </plugin>
        </plugins>
    </build>

```