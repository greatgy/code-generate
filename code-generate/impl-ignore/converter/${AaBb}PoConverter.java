package ${pkg_name};

import org.springframework.beans.BeanUtils;

/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
public class ${AaBb}PoConverter {
    public static ${AaBb} po2Bo(${AaBb}PO ${aaBb}PO) {
        if (${aaBb}PO == null) {
            return null;
        }

        ${AaBb} ${aaBb} = new ${AaBb}();
        BeanUtils.copyProperties(${aaBb}PO, ${aaBb});
        return ${aaBb};
    }

    public static ${AaBb}PO bo2Po(${AaBb} ${aaBb}) {
        if (${aaBb} == null) {
            return null;
        }

        ${AaBb}PO ${aaBb}PO = new ${AaBb}PO();
        BeanUtils.copyProperties(${aaBb}, ${aaBb}PO);
        return ${aaBb}PO;
    }
}
