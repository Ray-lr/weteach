package com.legend.cloud.campus.service.campus.impl;

import com.legend.cloud.campus.dao.mapper.campus.CampusCourseLessonMapper;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLesson;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLessonExample;
import com.legend.cloud.campus.service.campus.CampusCourseLessonService;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2018/3/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CampusCourseLessonServiceImpl extends AbstractLegendService<CampusCourseLesson> implements CampusCourseLessonService {

    @Resource
    private CampusCourseLessonMapper campusCourseLessonMapper;

    @Override
    public Mapper<CampusCourseLesson> getMapper() {
        return campusCourseLessonMapper;
    }

    @Override
    protected Object getExample(CampusCourseLesson campusCourseLesson, String order, String sort) {
        CampusCourseLessonExample example = new CampusCourseLessonExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusCourseLessonExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusCourseLesson == null) {
            return example;
        }

        if (campusCourseLesson.getId() != null) {
            criteria.andIdEqualTo(campusCourseLesson.getId());
        }
        if (campusCourseLesson.getCourseId() != null) {
            criteria.andCourseIdEqualTo(campusCourseLesson.getCourseId());
        }
        if (campusCourseLesson.getBeginTime() != null) {
            criteria.andBeginTimeEqualTo(campusCourseLesson.getBeginTime());
        }
        if (campusCourseLesson.getEndTime() != null) {
            criteria.andEndTimeEqualTo(campusCourseLesson.getEndTime());
        }
        if (campusCourseLesson.getLocation() != null) {
            criteria.andLocationEqualTo(campusCourseLesson.getLocation());
        }
        if (campusCourseLesson.getStatus() != null) {
            criteria.andStatusEqualTo(campusCourseLesson.getStatus());
        }
        if (campusCourseLesson.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusCourseLesson.getCreateTime());
        }
        if (campusCourseLesson.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusCourseLesson.getUpdateTime());
        }
        if (campusCourseLesson.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusCourseLesson.getIsDeleted());
        }
        return example;
    }

}
