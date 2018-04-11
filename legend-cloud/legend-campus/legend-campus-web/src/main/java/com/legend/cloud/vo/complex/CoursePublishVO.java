package com.legend.cloud.vo.complex;

import com.legend.cloud.vo.base.BaseOrderVO;
import com.legend.cloud.vo.campus.CampusCourseLimitVO;
import com.legend.cloud.vo.campus.CampusCourseVO;
import com.legend.cloud.vo.campus.CampusOrderVO;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CoursePublishVO {
    /**
     * 发布课程提交的课程信息
     */
    @Valid
    private CampusCourseVO course;
    /**
     * 发布课程提交的限制条件
     */
    @Valid
    private CampusCourseLimitVO limit;
    /**
     * 基本订单表要先存订单基本信息
     */
    @Valid
    private BaseOrderVO base;
    /**
     * 订单表存订单详细信息
     */
    @Valid
    private CampusOrderVO order;
}
