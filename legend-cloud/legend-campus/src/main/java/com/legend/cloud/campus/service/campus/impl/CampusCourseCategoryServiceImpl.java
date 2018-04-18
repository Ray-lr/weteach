package com.legend.cloud.campus.service.campus.impl;

import com.legend.cloud.campus.dao.mapper.campus.CampusCourseCategoryMapper;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseCategory;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseCategoryExample;
import com.legend.cloud.campus.service.campus.CampusCourseCategoryService;
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
public class CampusCourseCategoryServiceImpl extends AbstractLegendService<CampusCourseCategory> implements CampusCourseCategoryService {

    @Resource
    private CampusCourseCategoryMapper campusCourseCategoryMapper;

    @Override
    public Mapper<CampusCourseCategory> getMapper() {
        return campusCourseCategoryMapper;
    }

    @Override
    protected Object getExample(CampusCourseCategory campusCourseCategory, String order, String sort) {
        CampusCourseCategoryExample example = new CampusCourseCategoryExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusCourseCategoryExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusCourseCategory == null) {
            return example;
        }

        if (campusCourseCategory.getId() != null) {
            criteria.andIdEqualTo(campusCourseCategory.getId());
        }
        if (campusCourseCategory.getName() != null) {
            criteria.andNameEqualTo(campusCourseCategory.getName());
        }
        if (campusCourseCategory.getParentId() != null) {
            criteria.andParentIdEqualTo(campusCourseCategory.getParentId());
        }
        if (campusCourseCategory.getAbbreviation() != null) {
            criteria.andAbbreviationEqualTo(campusCourseCategory.getAbbreviation());
        }
        if (campusCourseCategory.getDescription() != null) {
            criteria.andDescriptionEqualTo(campusCourseCategory.getDescription());
        }
        if (campusCourseCategory.getTypeCourseCategory() != null) {
            criteria.andTypeCourseCategoryEqualTo(campusCourseCategory.getTypeCourseCategory());
        }
        if (campusCourseCategory.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusCourseCategory.getCreateTime());
        }
        if (campusCourseCategory.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusCourseCategory.getUpdateTime());
        }
        if (campusCourseCategory.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusCourseCategory.getIsDeleted());
        }
        return example;
    }

}
