package ${pkg_name};


/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
public interface ${AaBb}Service {
    ${AaBb} add${AaBb}(${AaBb} ${aaBb}) throws BusinessException;
        
    int update${AaBb}(${AaBb} ${aaBb}) throws BusinessException;

    int delete${AaBb}(${AaBb} ${aaBb}) throws BusinessException;

    ${AaBb} get${AaBb}(Integer userId, Integer appId, Integer id) throws BusinessException;

    PageInfo<${AaBb}> get${AaBb}List(${AaBb}SearchParam ${aaBb}SearchParam) throws BusinessException;
}
