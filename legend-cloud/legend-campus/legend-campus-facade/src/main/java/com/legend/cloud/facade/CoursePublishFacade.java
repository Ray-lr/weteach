package com.legend.cloud.facade;

import com.legend.cloud.entity.campus.CampusCourse;
import com.legend.cloud.entity.campus.CampusCourseLimit;

/**
 * @author lirui
 * @date 2018年4月10日15:35:39
 */
public interface CoursePublishFacade {
    /**
     * 数据库记录增加的行数
     * 课程发布时，在这三个表中同时添加数据，必须全部成功，否则回滚
     *
     * @param campusCourse      课程表
     * @param campusCourseLimit 课程限制表
     * @return 结果
     */
    int publish(CampusCourse campusCourse, CampusCourseLimit campusCourseLimit, String host);
}
