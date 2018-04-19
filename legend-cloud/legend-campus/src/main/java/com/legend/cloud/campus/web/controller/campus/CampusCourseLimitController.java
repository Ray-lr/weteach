package com.legend.cloud.campus.web.controller.campus;


import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLimit;
import com.legend.cloud.campus.model.pojo.vo.campus.CampusCourseLimitVO;
import com.legend.cloud.campus.service.campus.CampusCourseLimitService;
import com.legend.cloud.campus.web.controller.CampusController;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.group.option.AddGroup;
import com.legend.module.core.model.group.option.UpdateGroup;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.model.utils.PageUtils;
import com.legend.module.core.model.utils.QueryUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jim
 * @date 2018/4/6
 */
@RestController
@RequestMapping("/campus/courseLimit")
public class CampusCourseLimitController extends CampusController {

    @Resource
    private CampusCourseLimitService campusCourseLimitService;

    @GetMapping("/list")
    // @RequiresPermissions("campus:campuscourselimit:list")
    public Ajax list(CampusCourseLimitVO campusCourseLimitVO, QueryUtils query) {
        try {
            List<CampusCourseLimit> campusCourseLimitList = campusCourseLimitService.getList(campusCourseLimitVO.parseTo(),
                    query);
            List<CampusCourseLimitVO> campusCourseLimitVOList = new CampusCourseLimitVO().parseFrom(campusCourseLimitList);
            PageUtils pageUtils = new PageUtils(campusCourseLimitVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusCourseLimitVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
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


    @PostMapping("/add")
    // @RequiresPermissions("campus:campuscourselimit:add")
    public Ajax add(@Validated(AddGroup.class) CampusCourseLimitVO campusCourseLimitVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = campusCourseLimitService.save(campusCourseLimitVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("campus:campuscourselimit:update")
    public Ajax update(@Validated(UpdateGroup.class) CampusCourseLimitVO campusCourseLimitVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = campusCourseLimitService.updateById(campusCourseLimitVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
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
