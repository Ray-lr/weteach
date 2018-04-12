package com.legend.cloud.vo.campus.complex;

import com.legend.cloud.vo.campus.CampusCourseLimitVO;
import com.legend.cloud.vo.campus.CampusCourseVO;
import lombok.Data;

import javax.validation.Valid;

/**
 * @author Administrator
 * @date 2018/4/12
 */
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
}
