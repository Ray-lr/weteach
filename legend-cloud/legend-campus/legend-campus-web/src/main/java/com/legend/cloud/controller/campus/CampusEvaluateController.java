package com.legend.cloud.controller.campus;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.campus.CampusEvaluate;
import com.legend.cloud.service.campus.CampusEvaluateService;
import com.legend.cloud.vo.campus.CampusEvaluateVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
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
@RequestMapping("/campus/evaluate")
public class CampusEvaluateController extends CampusController {

    @Resource
    private CampusEvaluateService campusEvaluateService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("campus:campusevaluate:list")
    public Ajax list(CampusEvaluateVO campusEvaluateVO, Query query) {
        try {
            List<CampusEvaluate> campusEvaluateList = campusEvaluateService.getList(campusEvaluateVO.parseTo(),
                    query);
            List<CampusEvaluateVO> campusEvaluateVOList = campusEvaluateList.stream().map((entity) ->
                    new CampusEvaluateVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusEvaluateVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusEvaluateVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("campus:campusevaluate:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusEvaluate campusEvaluate = campusEvaluateService.getById(id);
            CampusEvaluateVO campusEvaluateVO = new CampusEvaluateVO().parseFrom(campusEvaluate);
            return Ajax.success(campusEvaluateVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("campus:campusevaluate:add")
    public Ajax add(@Validated CampusEvaluateVO campusEvaluateVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int saveResult = campusEvaluateService.save(campusEvaluateVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("campus:campusevaluate:update")
    public Ajax update(@Validated CampusEvaluateVO campusEvaluateVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int updateResult = campusEvaluateService.updateById(campusEvaluateVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("campus:campusevaluate:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusEvaluateService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
