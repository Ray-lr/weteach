package com.legend.cloud.controller.campus;


import com.legend.cloud.entity.campus.CampusCourseLimit;
import com.legend.cloud.service.campus.CampusCourseLimitService;
import com.legend.cloud.vo.campus.CampusCourseLimitVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
import com.legend.module.core.web.controller.LegendController;
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
@RequestMapping("/campus/courseLimit")
public class CampusCourseLimitController extends LegendController {

    @Resource
    private CampusCourseLimitService campusCourseLimitService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("campus:campuscourselimit:list")
    public Ajax list(CampusCourseLimitVO campusCourseLimitVO, Query query) {
        try {
            List<CampusCourseLimit> campusCourseLimitList = campusCourseLimitService.getList(campusCourseLimitVO.parseTo(),
                    query);
            List<CampusCourseLimitVO> campusCourseLimitVOList = campusCourseLimitList.stream().map((entity) ->
                    new CampusCourseLimitVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusCourseLimitVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusCourseLimitVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("campus:campuscourselimit:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusCourseLimit campusCourseLimit = campusCourseLimitService.getById(id);
            CampusCourseLimitVO campusCourseLimitVO = new CampusCourseLimitVO().parseFrom(campusCourseLimit);
            return Ajax.success(campusCourseLimitVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("campus:campuscourselimit:add")
    public Ajax add(@Validated CampusCourseLimitVO campusCourseLimitVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int saveResult = campusCourseLimitService.save(campusCourseLimitVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("campus:campuscourselimit:update")
    public Ajax update(@Validated CampusCourseLimitVO campusCourseLimitVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int updateResult = campusCourseLimitService.updateById(campusCourseLimitVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("campus:campuscourselimit:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusCourseLimitService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
