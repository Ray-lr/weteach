package com.legend.cloud.campus.service.campus.impl;

import com.legend.cloud.campus.dao.mapper.campus.CampusCourseMapper;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourse;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseExample;
import com.legend.cloud.campus.service.campus.CampusCourseService;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Jim
 * @date 2018/4/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CampusCourseServiceImpl extends AbstractLegendService<CampusCourse> implements CampusCourseService {

    @Resource
    private CampusCourseMapper campusCourseMapper;

    @Override
    public Mapper<CampusCourse> getMapper() {
        return campusCourseMapper;
    }

    @Override
    protected Object getExample(CampusCourse campusCourse, String order, String sort) {
        CampusCourseExample example = new CampusCourseExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusCourseExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusCourse == null) {
            return example;
        }

        if (campusCourse.getId() != null) {
            criteria.andIdEqualTo(campusCourse.getId());
        }
        if (campusCourse.getUserId() != null) {
            criteria.andUserIdEqualTo(campusCourse.getUserId());
        }
        if (campusCourse.getTitle() != null) {
            criteria.andTitleEqualTo(campusCourse.getTitle());
        }
        if (campusCourse.getDescription() != null) {
            criteria.andDescriptionEqualTo(campusCourse.getDescription());
        }
        if (campusCourse.getRemark() != null) {
            criteria.andRemarkEqualTo(campusCourse.getRemark());
        }
        if (campusCourse.getDept() != null) {
            criteria.andDeptEqualTo(campusCourse.getDept());
        }
        if (campusCourse.getMajor() != null) {
            criteria.andMajorEqualTo(campusCourse.getMajor());
        }
        if (campusCourse.getCourse() != null) {
            criteria.andCourseEqualTo(campusCourse.getCourse());
        }
        if (campusCourse.getLessonNum() != null) {
            criteria.andLessonNumEqualTo(campusCourse.getLessonNum());
        }
        if (campusCourse.getPayCredits() != null) {
            criteria.andPayCreditsEqualTo(campusCourse.getPayCredits());
        }
        if (campusCourse.getGetCredits() != null) {
            criteria.andGetCreditsEqualTo(campusCourse.getGetCredits());
        }
        if (campusCourse.getPublishTime() != null) {
            criteria.andPublishTimeEqualTo(campusCourse.getPublishTime());
        }
        if (campusCourse.getApplyEndTime() != null) {
            criteria.andApplyEndTimeEqualTo(campusCourse.getApplyEndTime());
        }
        if (campusCourse.getBeginTime() != null) {
            criteria.andBeginTimeEqualTo(campusCourse.getBeginTime());
        }
        if (campusCourse.getEndTime() != null) {
            criteria.andEndTimeEqualTo(campusCourse.getEndTime());
        }
        if (campusCourse.getFinishTime() != null) {
            criteria.andFinishTimeEqualTo(campusCourse.getFinishTime());
        }
        if (campusCourse.getPersonNum() != null) {
            criteria.andPersonNumEqualTo(campusCourse.getPersonNum());
        }
        if (campusCourse.getTypeCourse() != null) {
            criteria.andTypeCourseEqualTo(campusCourse.getTypeCourse());
        }
        if (campusCourse.getStatus() != null) {
            criteria.andStatusEqualTo(campusCourse.getStatus());
        }
        if (campusCourse.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusCourse.getCreateTime());
        }
        if (campusCourse.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusCourse.getUpdateTime());
        }
        if (campusCourse.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusCourse.getIsDeleted());
        }
        return example;
    }

    @Override
    public int save(CampusCourse campusCourse) {
        if (campusCourse.getCourse() == null) {
            Date now = new Date();
            campusCourse.setCreateTime(now);
            campusCourse.setUpdateTime(now);
        }
        return super.save(campusCourse);
    }
}
