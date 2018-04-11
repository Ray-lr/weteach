package com.legend.cloud.campus.facade.impl;

import com.legend.cloud.campus.facade.CoursePublishFacade;
import com.legend.cloud.entity.base.BaseOrder;
import com.legend.cloud.entity.campus.CampusCourse;
import com.legend.cloud.entity.campus.CampusCourseLimit;
import com.legend.cloud.entity.campus.CampusOrder;
import com.legend.cloud.service.base.BaseOrderService;
import com.legend.cloud.service.campus.CampusCourseLimitService;
import com.legend.cloud.service.campus.CampusCourseService;
import com.legend.cloud.service.campus.CampusOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lirui
 * @date 2018年4月9日23:03:22
 * 课程发布时调用三个service，分别在baseOrder表，campusOrder表,campusCourse表添加一条数据
 * 必须同时添加，有一个失败，则事务回滚
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CoursePublishFacadeImpl implements CoursePublishFacade {
    @Resource
    private CampusCourseService campusCourseService;
    @Resource
    private CampusCourseLimitService campusCourseLimitService;
    @Resource
    private BaseOrderService baseOrderService;
    @Resource
    private CampusOrderService campusOrderService;

    public int publish(BaseOrder baseOrder, CampusOrder campusOrder, CampusCourse campusCourse, CampusCourseLimit campusCourseLimit) {
        try {
            Date date = new Date();
            baseOrder.setCreateTime(date);
            baseOrder.setUpdateTime(date);
            int result = baseOrderService.save(baseOrder);
            campusCourse.setCreateTime(date);
            campusCourse.setUpdateTime(date);
            result += campusCourseService.save(campusCourse);
            campusOrder.setCreateTime(date);
            campusOrder.setUpdateTime(date);
            campusOrder.setBaseOrderId(baseOrder.getId());
            campusOrder.setCourseId(campusCourse.getId());
            campusOrder.setIsHost(true);
            campusOrder.setTypeCourse("发起");
            result += campusOrderService.save(campusOrder);
            campusCourseLimit.setCourseId(campusCourse.getId());
            campusCourseLimit.setCreateTime(date);
            campusCourseLimit.setUpdateTime(date);
            result += campusCourseLimitService.save(campusCourseLimit);
            return result == 4 ? result : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
