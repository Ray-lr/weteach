package com.legend.cloud.controller.campus;


import com.alibaba.fastjson.JSON;
import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.campus.CampusCourse;
import com.legend.cloud.entity.campus.CampusCourseLimit;
import com.legend.cloud.facade.CoursePublishFacade;
import com.legend.cloud.service.campus.CampusCourseService;
import com.legend.cloud.vo.campus.CampusCourseVO;
import com.legend.cloud.vo.campus.CampusUserInfoVO;
import com.legend.cloud.vo.campus.complex.CoursePublishVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jim
 * @date 2018/4/6
 */
@RestController
@RequestMapping("/campus/course")
public class CampusCourseController extends CampusController {

    @Resource
    private CampusCourseService campusCourseService;
    @Resource
    private CoursePublishFacade coursePublishFacade;

    @GetMapping("/list")
    @RequiresPermissions("campus:course:list")
    public Ajax list(CampusCourseVO campusCourseVO, Query query) {
        try {
            campusCourseVO.setTypeCourse("求学");
            List<CampusCourse> campusCourseList = campusCourseService.getList(campusCourseVO.parseTo(),
                    query);
            List<CampusCourseVO> campusCourseVOList = campusCourseList.stream().map((entity) ->
                    new CampusCourseVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusCourseVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusCourseVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (AuthorizationException e) {
            return Ajax.error();
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("details/{id}")
    // @RequiresPermissions("campus:course:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusCourse campusCourse = campusCourseService.getById(id);
            CampusCourseVO campusCourseVO = new CampusCourseVO().parseFrom(campusCourse);
            return Ajax.success(campusCourseVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("campus:course:add")
    public Ajax add(@Validated CoursePublishVO coursePublishVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            CampusUserInfoVO currentUser = JSON.parseObject(String.valueOf(getCurrentUser()), CampusUserInfoVO.class);
            CampusCourse campusCourse = coursePublishVO.getCourse().parseTo(Column.ID);
            campusCourse.setUserId(currentUser.getBaseUserId());
            CampusCourseLimit campusCourseLimit = coursePublishVO.getLimit().parseTo(Column.ID);
            int saveResult = coursePublishFacade.publish(campusCourse, campusCourseLimit, currentUser.getHost());
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE,
                    AjaxCode.SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("campus:course:update")
    public Ajax update(@Validated CampusCourseVO campusCourseVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = campusCourseService.updateById(campusCourseVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    // @RequiresPermissions("campus:course:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusCourseService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
