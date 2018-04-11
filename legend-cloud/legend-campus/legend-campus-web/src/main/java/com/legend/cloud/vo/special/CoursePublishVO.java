package com.legend.cloud.vo.special;

import com.legend.cloud.vo.campus.CampusCourseLimitVO;
import com.legend.cloud.vo.campus.CampusCourseVO;
import lombok.Data;

@Data
public class CoursePublishVO {
    /**
     * 发布课程提交的课程信息
     */
    CampusCourseVO campusCourseVO;
    /**
     * 发布课程提交的限制条件
     */
    CampusCourseLimitVO campusCourseLimitVO;
}
