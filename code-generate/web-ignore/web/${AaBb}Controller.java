package ${pkg_name};

import cc.linkedme.entities.PageInfoResp;
import cc.linkedme.errorcode.BaseErrorCode;
import cc.linkedme.page.interceptor.RequiredLogin;
import cc.linkedme.page.model.FrameResp;
import cc.linkedme.util.Preconditions;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
@RestController
@RequestMapping("${aaBb}")
public class ${AaBb}Controller extends BaseController {

    @Resource
    private ${AaBb}Service ${aaBb}Service;

    /**
     * 新建漏斗
     *
     * @param ${aaBb}Request
     * @return
     */
    @RequiredLogin
    @PostMapping("create")
    public FrameResp create${AaBb}(@RequestBody @Valid ${AaBb}Request ${aaBb}Request) {
        logger.info("create${AaBb}, ${aaBb}Request:{}", ${aaBb}Request);

        ${AaBb} ${aaBb} = ${AaBb}VoConverter.vo2Bo(${aaBb}Request);

        ${AaBb} new${AaBb} = ${aaBb}Service.add${AaBb}(${aaBb});

        logger.info("createApp, ${aaBb}Request:{}, new${AaBb}:{}", ${aaBb}Request, new${AaBb});
        return buildSuccessResp();
    }
    
    /**
     * 修改
     *
     * @param ${aaBb}Request
     * @return
     */
    @RequiredLogin
    @PostMapping("update")
    public FrameResp update${AaBb}(@RequestBody @Valid ${AaBb}Request ${aaBb}Request) {
        logger.info("update${AaBb}, ${aaBb}Request:{}", ${aaBb}Request);

        ${AaBb} ${aaBb} = ${AaBb}VoConverter.vo2Bo(${aaBb}Request);

        int row = ${aaBb}Service.update${AaBb}(${aaBb});

        logger.info("update${AaBb}, ${aaBb}Request:{}, row:{}", ${aaBb}Request, row);
        return buildSuccessResp();
    }

    /**
     * 删除
     *
     * @param ${aaBb}Request
     * @return
     */
    @RequiredLogin
    @PostMapping("delete")
    public FrameResp delete${AaBb}(@RequestBody @Valid ${AaBb}Request ${aaBb}Request) {
        logger.info("delete${AaBb}, ${aaBb}Request:{}", ${aaBb}Request);

        ${AaBb} ${aaBb} = ${AaBb}VoConverter.vo2Bo(${aaBb}Request);

        int row = ${aaBb}Service.delete${AaBb}(${aaBb});

        logger.info("delete${AaBb}, ${aaBb}Request:{}, row:{}", ${aaBb}Request, row);
        return buildSuccessResp();
    }

    /**
     * 查询
     *
     * @param userId
     * @param appId
     * @param id
     * @return
     */
    @RequiredLogin
    @GetMapping("info")
    public FrameResp get${AaBb}(@RequestParam("user_id") Integer userId,
                                   @RequestParam("app_id") Integer appId,
                                   @RequestParam("id") Integer id) {
        logger.info("get${AaBb}, userId:{}, appId:{}, id:{}", userId, appId, id);

        Preconditions.checkNotNull(userId, new ${AaBb}Exception(BaseErrorCode.PARAM_NULL_ERROR.setMessage("user_id不能为空")));
        Preconditions.checkNotNull(appId, new ${AaBb}Exception(BaseErrorCode.PARAM_NULL_ERROR.setMessage("app_id不能为空")));

        ${AaBb} ${aaBb} = ${aaBb}Service.get${AaBb}(userId, appId, id);

        ${AaBb}Response ${aaBb}Response = ${AaBb}VoConverter.bo2Vo(${aaBb});

        logger.info("get${AaBb}, id:{}, ${aaBb}:{}, ${aaBb}Response:{}", id, ${aaBb}, ${aaBb}Response);
        return buildSuccessResp(${aaBb}Response);
    }

    /**
     * 查询列表
     *
     * @param userId
     * @param appId
     * @return
     */
    @RequiredLogin
    @GetMapping("list")
    public FrameResp get${AaBb}List(@RequestParam("user_id") Integer userId,
                                       @RequestParam("app_id") Integer appId,
                                       @RequestParam("page_num") Integer pageNum,
                                       @RequestParam("page_size") Integer pageSize) {
        logger.info("get${AaBb}List, userId:{}, appId:{}, pageNum:{}, pageSize:{}", userId, appId, pageNum, pageSize);

        ${AaBb}SearchParam ${aaBb}SearchParam = new ${AaBb}SearchParam();
        ${aaBb}SearchParam.setAppId(appId);
        ${aaBb}SearchParam.setPageNum(pageNum);
        ${aaBb}SearchParam.setPageSize(pageSize);
        PageInfo<${AaBb}> ${aaBb}PageInfo = ${aaBb}Service.get${AaBb}List(${aaBb}SearchParam);

        List<${AaBb}Response> ${aaBb}ResponseList = ${aaBb}PageInfo.getList().stream().map(${AaBb}VoConverter::bo2Vo).collect(Collectors.toList());
        PageInfoResp<${AaBb}Response> ${aaBb}ResponsePageInfoResp = new PageInfoResp<>(${aaBb}PageInfo, ${aaBb}ResponseList);

        logger.debug("get${AaBb}List, userId:{}, appId:{}, ${aaBb}ResponsePageInfoResp:{}", userId, appId, ${aaBb}ResponsePageInfoResp);
        return buildSuccessResp(${aaBb}ResponsePageInfoResp);
    }

}
