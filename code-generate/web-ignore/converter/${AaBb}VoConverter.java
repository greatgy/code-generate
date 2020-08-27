package ${pkg_name};

import org.springframework.beans.BeanUtils;

/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
public class ${AaBb}VoConverter {

    public static ${AaBb} vo2Bo(${AaBb}Request ${aaBb}Request) {
        if (${aaBb}Request == null) {
            return null;
        }

        ${AaBb} ${aaBb} = new ${AaBb}();
        BeanUtils.copyProperties(${aaBb}Request, ${aaBb});
        return ${aaBb};
    }

    public static ${AaBb}Response bo2Vo(${AaBb} ${aaBb}) {
        if (${aaBb} == null) {
            return null;
        }

        ${AaBb}Response ${aaBb}Response = new ${AaBb}Response();
        BeanUtils.copyProperties(${aaBb}, ${aaBb}Response);
        return ${aaBb}Response;
    }
}
