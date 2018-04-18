package com.legend.cloud.campus.web.controller.campus;


import com.alibaba.fastjson.JSON;
import com.legend.cloud.campus.facade.CoursePublishFacade;
import com.legend.cloud.campus.model.pojo.entity.base.BaseUser;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourse;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLimit;
import com.legend.cloud.campus.model.pojo.vo.campus.CampusAccountVO;
import com.legend.cloud.campus.model.pojo.vo.campus.CampusCourseVO;
import com.legend.cloud.campus.model.pojo.vo.campus.complex.CoursePublishVO;
import com.legend.cloud.campus.service.base.BaseUserService;
import com.legend.cloud.campus.service.campus.CampusCourseLimitService;
import com.legend.cloud.campus.service.campus.CampusCourseService;
import com.legend.cloud.campus.web.controller.CampusController;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.model.pojo.vo.user.UserVO;
import com.legend.module.core.model.utils.PageUtils;
import com.legend.module.core.model.utils.QueryUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger LOGGER = LoggerFactory.getLogger(CampusCourseController.class);

    @Resource
    private CampusCourseService campusCourseService;
    @Resource
    private CoursePublishFacade coursePublishFacade;
    @Resource
    private CampusCourseLimitService campusCourseLimitService;
    @Resource
    private BaseUserService baseUserService;

    @GetMapping("/list")
    @RequiresPermissions("campus:course:list")
    public Ajax list(CampusCourseVO campusCourseVO, QueryUtils query) {
        try {
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
            Subject subject = SecurityUtils.getSubject();
            UserVO currentUser = (UserVO) subject.getPrincipal();
            CampusCourse campusCourse = coursePublishVO.getCourse().parseTo(Column.ID);
            campusCourse.setUserId(currentUser.getId());
            CampusCourseLimit campusCourseLimit = coursePublishVO.getLimit() != null ? coursePublishVO.getLimit().parseTo
                    (Column.ID) : null;
            return coursePublishFacade.publish(campusCourse, campusCourseLimit, currentUser.getTypeUser()) == 1 ? Ajax.success
                    (AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE,
                    AjaxCode.SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/apply/{courseId}")
    public Ajax apply(@PathVariable Integer courseId) {
        CampusCourse campusCourse = campusCourseService.getById(courseId);
        if (campusCourse == null) {
            return Ajax.error("课程不存在");
        }
        long now = System.currentTimeMillis();
        if (campusCourse.getApplyEndTime() != null) {
            if (now > campusCourse.getApplyEndTime().getTime()) {
                return Ajax.error("报名时间已过");
            }
        }
        CampusCourseLimit campusCourseLimit = new CampusCourseLimit();
        campusCourseLimit.setCourseId(courseId);
        campusCourseLimit = campusCourseLimitService.get(campusCourseLimit);
        if (campusCourseLimit == null) {
            return Ajax.success("报名成功");
        }
        CampusAccountVO currentUser = JSON.parseObject(String.valueOf(getCurrentUser()), CampusAccountVO.class);

        BaseUser baseUser = baseUserService.getById(currentUser.getUserId());
        return Ajax.success("报名成功");

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
