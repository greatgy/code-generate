package ${pkg_name};

import cc.linkedme.errorcode.BaseErrorCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
@Slf4j
@Component("${aaBb}Persist")
public class ${AaBb}Persist {
    @Resource
    private ${AaBb}POMapper ${aaBb}POMapper;

    public ${AaBb} add${AaBb}(${AaBb} ${aaBb}) {
        log.info("add${AaBb}, ${aaBb}:{}", ${aaBb});

        ${AaBb}PO ${aaBb}PO = ${AaBb}PoConverter.bo2Po(${aaBb});

        ${aaBb}PO.setGmtCreate(new Date());
        ${aaBb}PO.setGmtUpdate(new Date());

        int row = ${aaBb}POMapper.insertSelective(${aaBb}PO);
        if (0 == row) {
            log.warn("add${AaBb}, ${aaBb}:{}, cause:{}", ${aaBb}, "添加失败");
            throw new ${AaBb}Exception(BaseErrorCode.FAIL);
        }
        log.info("add${AaBb}, ${aaBb}:{}, row:{}", ${aaBb}, row);
        return ${AaBb}PoConverter.po2Bo(${aaBb}PO);
    }

    public int update${AaBb}(${AaBb} ${aaBb}) {
        log.info("update${AaBb}, ${aaBb}:{}", ${aaBb});

        ${AaBb}PO ${aaBb}PO = ${AaBb}PoConverter.bo2Po(${aaBb});
        ${AaBb}POExample example = new ${AaBb}POExample();
        example.createCriteria().andIdEqualTo(${aaBb}.getId());

        ${aaBb}PO.setGmtUpdate(new Date());
        
        int row = ${aaBb}POMapper.updateByExampleSelective(${aaBb}PO, example);
        if (row == 0) {
            log.warn("update${AaBb}, ${aaBb}:{}, cause:{}", ${aaBb}, "更新失败");
            throw new ${AaBb}Exception(BaseErrorCode.FAIL.setMessage("更新失败"));
        }
        log.info("update${AaBb}, ${aaBb}:{}, row:{}", ${aaBb}, row);
        return row;
    }

    public int delete${AaBb}(${AaBb} ${aaBb}) {
        log.info("delete${AaBb}, ${aaBb}:{}", ${aaBb});

        ${AaBb}POExample example = new ${AaBb}POExample();
        example.createCriteria().andIdEqualTo(${aaBb}.getId());
        int row = ${aaBb}POMapper.deleteByExample(example);
        if (row == 0) {
            log.warn("delete${AaBb}, ${aaBb}:{}, cause:{}", ${aaBb}, "删除失败");
            throw new ${AaBb}Exception(BaseErrorCode.FAIL.setMessage("删除失败"));
        }
        log.info("delete${AaBb}, ${aaBb}:{}, row:{}", ${aaBb}, row);
        return row;
    }

    public ${AaBb} get${AaBb}(Integer userId, Integer appId, Integer id) {
        log.info("get${AaBb}, userId:{}, appId:{}, id:{}", userId, appId, id);

        ${AaBb}PO ${aaBb}PO = ${aaBb}POMapper.selectByPrimaryKey(id);

        ${AaBb} ${aaBb} = ${AaBb}PoConverter.po2Bo(${aaBb}PO);

        log.info("get${AaBb}, userId:{}, appId:{}, id:{}, ${aaBb}:{}", userId, appId, id, ${aaBb});

        return ${aaBb};
    }

    public PageInfo<${AaBb}> get${AaBb}List(${AaBb}SearchParam ${aaBb}SearchParam) {
        log.info("get${AaBb}List, ${aaBb}SearchParam:{}", ${aaBb}SearchParam);

        ${AaBb}POExample example = new ${AaBb}POExample();
        example.createCriteria().andAppIdEqualTo(${aaBb}SearchParam.getAppId());

        PageHelper.startPage(${aaBb}SearchParam.getPageNum(), ${aaBb}SearchParam.getPageSize());
        PageInfo<${AaBb}PO> ${aaBb}POPageInfo = new PageInfo<>(${aaBb}POMapper.selectByExample(example));
        List<${AaBb}> ${aaBb}List = ${aaBb}POPageInfo.getList().stream().map(${AaBb}PoConverter::po2Bo).collect(Collectors.toList());

        PageInfo<${AaBb}> ${aaBb}PageInfo = new PageInfo<>();
        ${aaBb}POPageInfo.setList(null);
        BeanUtils.copyProperties(${aaBb}POPageInfo, ${aaBb}PageInfo);
        ${aaBb}PageInfo.setList(${aaBb}List);

        log.debug("get${AaBb}List, ${aaBb}SearchParam:{}, ${aaBb}PageInfo:{}", ${aaBb}SearchParam, ${aaBb}PageInfo);
        return ${aaBb}PageInfo;
    }

}
