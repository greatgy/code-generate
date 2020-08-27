package ${pkg_name};

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ${AaBb}Response {

    private Integer userId;
    private Integer appId;

}
