package com.legend.cloud.campus.service.campus.impl;

import com.legend.cloud.campus.dao.mapper.campus.CampusStatisticsMapper;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusStatistics;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusStatisticsExample;
import com.legend.cloud.campus.service.campus.CampusStatisticsService;
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
public class CampusStatisticsServiceImpl extends AbstractLegendService<CampusStatistics> implements CampusStatisticsService {

    @Resource
    private CampusStatisticsMapper campusStatisticsMapper;

    @Override
    public Mapper<CampusStatistics> getMapper() {
        return campusStatisticsMapper;
    }

    @Override
    protected Object getExample(CampusStatistics campusStatistics, String order, String sort) {
        CampusStatisticsExample example = new CampusStatisticsExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusStatisticsExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusStatistics == null) {
            return example;
        }

        if (campusStatistics.getId() != null) {
            criteria.andIdEqualTo(campusStatistics.getId());
        }
        if (campusStatistics.getDescription() != null) {
            criteria.andDescriptionEqualTo(campusStatistics.getDescription());
        }
        if (campusStatistics.getRemark() != null) {
            criteria.andRemarkEqualTo(campusStatistics.getRemark());
        }
        if (campusStatistics.getData() != null) {
            criteria.andDataEqualTo(campusStatistics.getData());
        }
        if (campusStatistics.getProbability() != null) {
            criteria.andProbabilityEqualTo(campusStatistics.getProbability());
        }
        if (campusStatistics.getCode() != null) {
            criteria.andCodeEqualTo(campusStatistics.getCode());
        }
        if (campusStatistics.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusStatistics.getCreateTime());
        }
        if (campusStatistics.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusStatistics.getUpdateTime());
        }
        if (campusStatistics.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusStatistics.getIsDeleted());
        }
        return example;
    }

}
