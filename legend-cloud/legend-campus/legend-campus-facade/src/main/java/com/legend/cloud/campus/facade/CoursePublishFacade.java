package com.legend.cloud.campus.facade;

import com.legend.cloud.entity.base.BaseOrder;
import com.legend.cloud.entity.campus.CampusCourse;
import com.legend.cloud.entity.campus.CampusCourseLimit;
import com.legend.cloud.entity.campus.CampusOrder;

public interface CoursePublishFacade {
    /**
     * @param baseOrder         基本订单表
     * @param campusOrder       订单表
     * @param campusCourse      课程表
     * @param campusCourseLimit 课程限制表
     * @return 数据库记录增加的行数
     * 课程发布时，在这三个表中同时添加数据，必须全部成功，否则回滚
     * @author lirui
     * @date 2018年4月10日15:35:39
     */
    int publish(BaseOrder baseOrder, CampusOrder campusOrder, CampusCourse campusCourse, CampusCourseLimit campusCourseLimit);
}
