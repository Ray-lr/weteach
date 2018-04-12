package com.legend.cloud.facade.impl;

import com.legend.cloud.entity.base.BaseOrder;
import com.legend.cloud.entity.campus.CampusCourse;
import com.legend.cloud.entity.campus.CampusCourseLimit;
import com.legend.cloud.entity.campus.CampusOrder;
import com.legend.cloud.facade.CoursePublishFacade;
import com.legend.cloud.service.base.BaseOrderService;
import com.legend.cloud.service.campus.CampusCourseLimitService;
import com.legend.cloud.service.campus.CampusCourseService;
import com.legend.cloud.service.campus.CampusOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 课程发布时调用四个service，分别在baseOrder表，campusOrder表,campusCourse表，和campusCourseLimit表添加一条数据
 * 必须同时添加，有一个失败，则事务回滚
 *
 * @author lirui
 * @date 2018年4月9日23:03:22
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

    @Override
    public int publish(CampusCourse campusCourse, CampusCourseLimit campusCourseLimit, String host) {
        Date now = new Date();
        campusCourse.setCreateTime(now);
        campusCourse.setUpdateTime(now);
        if (campusCourseService.save(campusCourse) <= 0) {
            return 0;
        }
        campusCourseLimit.setCourseId(campusCourse.getId());
        campusCourseLimit.setCreateTime(now);
        campusCourseLimit.setUpdateTime(now);
        if (campusCourseLimitService.save(campusCourseLimit) == 0) {
            return 0;
        }
        // 从campusCourse中获取相应信息并存储到baseOrder中并保存
        BaseOrder baseOrder = new BaseOrder();
        baseOrder.setUserId(campusCourse.getUserId());
        baseOrder.setTypeUser(host);
        baseOrder.setOrderNumber(String.valueOf(System.currentTimeMillis()) + baseOrder.getUserId());
        baseOrder.setTitle(campusCourse.getTitle());
        baseOrder.setDescription(campusCourse.getDescription());
        baseOrder.setRemark(campusCourse.getRemark());
        baseOrder.setBeginTime(now);
        baseOrder.setCreateTime(now);
        baseOrder.setUpdateTime(now);
        if (baseOrderService.save(baseOrder) <= 0) {
            return 0;
        }
        // 赋值到campusOrder并保存
        CampusOrder campusOrder = new CampusOrder();
        campusOrder.setBaseOrderId(baseOrder.getId());
        campusOrder.setCourseId(campusCourse.getId());
        campusOrder.setTypeCourse(campusCourse.getTypeCourse());
        campusOrder.setIsHost(true);
        campusOrder.setCreateTime(now);
        campusOrder.setUpdateTime(now);
        if (campusOrderService.save(campusOrder) <= 0) {
            return 0;
        }
        return 1;
    }

}
