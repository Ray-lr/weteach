package com.legend.cloud.service.campus.impl;

import com.legend.cloud.dao.mapper.campus.CampusEvaluateMapper;
import com.legend.cloud.entity.campus.CampusEvaluate;
import com.legend.cloud.entity.campus.CampusEvaluateExample;
import com.legend.cloud.service.campus.CampusEvaluateService;
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
public class CampusEvaluateServiceImpl extends AbstractLegendService<CampusEvaluate> implements CampusEvaluateService {

    @Resource
    private CampusEvaluateMapper campusEvaluateMapper;

    @Override
    public Mapper<CampusEvaluate> getMapper() {
        return campusEvaluateMapper;
    }

    @Override
    protected Object getExample(CampusEvaluate campusEvaluate, String order, String sort) {
        CampusEvaluateExample example = new CampusEvaluateExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusEvaluateExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusEvaluate == null) {
            return example;
        }

        if (campusEvaluate.getId() != null) {
            criteria.andIdEqualTo(campusEvaluate.getId());
        }
        if (campusEvaluate.getUserId() != null) {
            criteria.andUserIdEqualTo(campusEvaluate.getUserId());
        }
        if (campusEvaluate.getCourseId() != null) {
            criteria.andCourseIdEqualTo(campusEvaluate.getCourseId());
        }
        if (campusEvaluate.getEvaluateStar() != null) {
            criteria.andEvaluateStarEqualTo(campusEvaluate.getEvaluateStar());
        }
        if (campusEvaluate.getDetail() != null) {
            criteria.andDetailEqualTo(campusEvaluate.getDetail());
        }
        if (campusEvaluate.getSuperaddition() != null) {
            criteria.andSuperadditionEqualTo(campusEvaluate.getSuperaddition());
        }
        if (campusEvaluate.getStatus() != null) {
            criteria.andStatusEqualTo(campusEvaluate.getStatus());
        }
        if (campusEvaluate.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusEvaluate.getCreateTime());
        }
        if (campusEvaluate.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusEvaluate.getUpdateTime());
        }
        if (campusEvaluate.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusEvaluate.getIsDeleted());
        }
        return example;
    }

}
