package ${pkg_name};

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ${AaBb}Request {

    @NotNull(message = "user_id不能为空")
    private Integer userId;
    @NotNull(message = "app_id不能为空")
    private Integer appId;

}
