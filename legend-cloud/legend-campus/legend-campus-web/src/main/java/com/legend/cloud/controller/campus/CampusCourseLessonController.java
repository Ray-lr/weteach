package com.legend.cloud.controller.campus;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.campus.CampusCourseLesson;
import com.legend.cloud.service.campus.CampusCourseLessonService;
import com.legend.cloud.vo.campus.CampusCourseLessonVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.group.option.AddGroup;
import com.legend.module.core.model.group.option.UpdateGroup;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/campus/courseLesson")
public class CampusCourseLessonController extends CampusController {

    @Resource
    private CampusCourseLessonService campusCourseLessonService;

    @GetMapping("/list")
    // @RequiresPermissions("campus:campuscourselesson:list")
    public Ajax list(CampusCourseLessonVO campusCourseLessonVO, Query query) {
        try {
            List<CampusCourseLesson> campusCourseLessonList = campusCourseLessonService.getList(campusCourseLessonVO.parseTo(),
                    query);
            List<CampusCourseLessonVO> campusCourseLessonVOList = campusCourseLessonList.stream().map((entity) ->
                    new CampusCourseLessonVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusCourseLessonVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusCourseLessonVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("campus:campuscourselesson:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusCourseLesson campusCourseLesson = campusCourseLessonService.getById(id);
            CampusCourseLessonVO campusCourseLessonVO = new CampusCourseLessonVO().parseFrom(campusCourseLesson);
            return Ajax.success(campusCourseLessonVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("campus:campuscourselesson:add")
    public Ajax add(@Validated(AddGroup.class) CampusCourseLessonVO campusCourseLessonVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = campusCourseLessonService.save(campusCourseLessonVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("campus:campuscourselesson:update")
    public Ajax update(@Validated(UpdateGroup.class) CampusCourseLessonVO campusCourseLessonVO, BindingResult
            bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = campusCourseLessonService.updateById(campusCourseLessonVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("campus:campuscourselesson:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusCourseLessonService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
