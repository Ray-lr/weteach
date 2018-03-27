package com.legend.cloud.controller.campus;


        import com.legend.cloud.entity.campus.CampusVerify;
        import com.legend.cloud.service.campus.CampusVerifyService;
        import com.legend.module.core.model.contant.arribute.Column;
        import com.legend.module.core.model.contant.arribute.Key;
        import com.legend.module.core.model.contant.code.result.AjaxCode;
        import com.legend.module.core.model.contant.message.result.AjaxMessage;
        import com.legend.module.core.model.json.result.Ajax;
        import com.legend.module.core.model.json.result.AjaxValidate;
        import com.legend.module.core.utils.PageUtils;
        import com.legend.module.core.utils.Query;
        import com.legend.module.core.web.controller.LegendController;
        import com.legend.cloud.vo.campus.CampusVerifyVO;
        import org.springframework.validation.BindingResult;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

        import javax.annotation.Resource;
        import java.util.List;
        import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/campus/verify")
public class CampusVerifyController extends LegendController {

    @Resource
    private CampusVerifyService campusVerifyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("campus:campusverify:list")
    public Ajax list(CampusVerifyVO campusVerifyVO, Query query) {
        try {
            List<CampusVerify> campusVerifyList = campusVerifyService.getList(campusVerifyVO.parseTo(),
                    query);
            List<CampusVerifyVO> campusVerifyVOList = campusVerifyList.stream().map((entity) ->
                    new CampusVerifyVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusVerifyVOList, campusVerifyVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusVerifyVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("campus:campusverify:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusVerify campusVerify =campusVerifyService.getById(id);
                CampusVerifyVO campusVerifyVO = new CampusVerifyVO().parseFrom(campusVerify);
            return Ajax.success(campusVerifyVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("campus:campusverify:add")
    public Ajax add(@Validated CampusVerifyVO campusVerifyVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int saveResult = campusVerifyService.save(campusVerifyVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("campus:campusverify:update")
    public Ajax update(@Validated CampusVerifyVO campusVerifyVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int updateResult = campusVerifyService.updateById(campusVerifyVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("campus:campusverify:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusVerifyService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
