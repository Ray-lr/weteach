package com.legend.cloud.campus.service.campus.impl;

import com.legend.cloud.campus.dao.mapper.campus.CampusCourseLimitMapper;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLimit;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLimitExample;
import com.legend.cloud.campus.service.campus.CampusCourseLimitService;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Jim
 * @date 2018/4/6
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CampusCourseLimitServiceImpl extends AbstractLegendService<CampusCourseLimit> implements CampusCourseLimitService {

    @Resource
    private CampusCourseLimitMapper campusCourseLimitMapper;

    @Override
    public Mapper<CampusCourseLimit> getMapper() {
        return campusCourseLimitMapper;
    }

    @Override
    protected Object getExample(CampusCourseLimit campusCourseLimit, String order, String sort) {
        CampusCourseLimitExample example = new CampusCourseLimitExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusCourseLimitExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusCourseLimit == null) {
            return example;
        }

        if (campusCourseLimit.getId() != null) {
            criteria.andIdEqualTo(campusCourseLimit.getId());
        }
        if (campusCourseLimit.getCourseId() != null) {
            criteria.andCourseIdEqualTo(campusCourseLimit.getCourseId());
        }
        if (campusCourseLimit.getDept() != null) {
            criteria.andDeptEqualTo(campusCourseLimit.getDept());
        }
        if (campusCourseLimit.getMajor() != null) {
            criteria.andMajorEqualTo(campusCourseLimit.getMajor());
        }
        if (campusCourseLimit.getSex() != null) {
            criteria.andSexEqualTo(campusCourseLimit.getSex());
        }
        if (campusCourseLimit.getGrade() != null) {
            criteria.andGradeEqualTo(campusCourseLimit.getGrade());
        }
        if (campusCourseLimit.getPersonUpper() != null) {
            criteria.andPersonUpperEqualTo(campusCourseLimit.getPersonUpper());
        }
        if (campusCourseLimit.getPersonLower() != null) {
            criteria.andPersonLowerEqualTo(campusCourseLimit.getPersonLower());
        }
        if (campusCourseLimit.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusCourseLimit.getCreateTime());
        }
        if (campusCourseLimit.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusCourseLimit.getUpdateTime());
        }
        if (campusCourseLimit.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusCourseLimit.getIsDeleted());
        }
        return example;
    }

    @Override
    public int save(CampusCourseLimit campusCourseLimit) {
        if (campusCourseLimit.getDept() != null || campusCourseLimit.getMajor() != null || campusCourseLimit.getGrade
                () != null || campusCourseLimit.getSex() != null || campusCourseLimit.getPersonUpper() != null ||
                campusCourseLimit.getPersonLower() != null) {
            if (campusCourseLimit.getCourseId() == null) {
                Date now = new Date();
                campusCourseLimit.setCreateTime(now);
                campusCourseLimit.setUpdateTime(now);
                return super.save(campusCourseLimit);
            }
        }
        return -1;
    }
}
