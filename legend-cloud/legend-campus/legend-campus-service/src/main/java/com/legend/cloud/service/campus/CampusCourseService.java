package com.legend.cloud.service.campus;

import com.legend.cloud.entity.campus.CampusCourse;
import com.legend.module.core.service.core.LegendService;
import com.legend.module.core.utils.Query;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/8
 */
public interface CampusCourseService extends LegendService<CampusCourse> {
    /**
     * 查询求学课程列表
     * 查询条件为：type_course为求学，status为3或4，未删除的记录
     *
     * @param campusCourse 求学的课程列表
     * @param query        分页
     * @return 课程List
     */
    List<CampusCourse> studyList(CampusCourse campusCourse, Query query);
}