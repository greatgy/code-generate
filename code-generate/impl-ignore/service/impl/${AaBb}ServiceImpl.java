package ${pkg_name};

import cc.linkedme.errorcode.BaseErrorCode;
import cc.linkedme.exception.BusinessException;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
@Slf4j
@Service("${aaBb}Service")
public class ${AaBb}ServiceImpl implements ${AaBb}Service {

    @Resource
    private ${AaBb}Cache ${aaBb}Cache;

    @Resource
    private ${AaBb}Persist ${aaBb}Persist;

    @Override
    public ${AaBb} add${AaBb}(${AaBb} ${aaBb}) throws BusinessException {
        log.info("add${AaBb}, ${aaBb}:{}", ${aaBb});

        ${AaBb} new${AaBb} = ${aaBb}Persist.add${AaBb}(${aaBb});
        if (new${AaBb} == null) {
            throw new ${AaBb}Exception(BaseErrorCode.FAIL.setMessage("失败"));
        }
        return new${AaBb};
    }

     @Override
    public int update${AaBb}(${AaBb} ${aaBb}) {
        log.info("update${AaBb}, ${aaBb}:{}", ${aaBb});

        int row = ${aaBb}Persist.update${AaBb}(${aaBb});
        return row;
    }

    @Override
    public int delete${AaBb}(${AaBb} ${aaBb}) {
        log.info("delete${AaBb}, ${aaBb}:{}", ${aaBb});

        int row = ${aaBb}Persist.delete${AaBb}(${aaBb});
        return row;
    }

    @Override
    public ${AaBb} get${AaBb}(Integer userId, Integer appId, Integer id) {
        log.info("get${AaBb}, userId:{}, appId:{}, id:{}", userId, appId, id);

        ${AaBb} ${aaBb} = ${aaBb}Persist.get${AaBb}(userId, appId, id);
        return ${aaBb};
    }

    @Override
    public PageInfo<${AaBb}> get${AaBb}List(${AaBb}SearchParam ${aaBb}SearchParam) {
        log.info("get${AaBb}List, ${aaBb}SearchParam:{}", ${aaBb}SearchParam);

        PageInfo<${AaBb}> ${aaBb}PageInfo = ${aaBb}Persist.get${AaBb}List(${aaBb}SearchParam);
        return ${aaBb}PageInfo;
    }
}
