package com.legend.cloud.service.base.impl;

import com.legend.cloud.dao.mapper.base.BaseAreasMapper;
import com.legend.cloud.entity.base.BaseAreas;
import com.legend.cloud.entity.base.BaseAreasExample;
import com.legend.cloud.service.base.BaseAreasService;
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
public class BaseAreasServiceImpl extends AbstractLegendService<BaseAreas> implements BaseAreasService {

    @Resource
    private BaseAreasMapper baseAreasMapper;

    @Override
    public Mapper<BaseAreas> getMapper() {
        return baseAreasMapper;
    }

    @Override
    protected Object getExample(BaseAreas baseAreas, String order, String sort) {
        BaseAreasExample example = new BaseAreasExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        BaseAreasExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (baseAreas == null) {
            return example;
        }

        if (baseAreas.getId() != null) {
            criteria.andIdEqualTo(baseAreas.getId());
        }
        if (baseAreas.getName() != null) {
            criteria.andNameEqualTo(baseAreas.getName());
        }
        if (baseAreas.getParentId() != null) {
            criteria.andParentIdEqualTo(baseAreas.getParentId());
        }
        if (baseAreas.getAbbreviation() != null) {
            criteria.andAbbreviationEqualTo(baseAreas.getAbbreviation());
        }
        if (baseAreas.getLongitude() != null) {
            criteria.andLongitudeEqualTo(baseAreas.getLongitude());
        }
        if (baseAreas.getLatitude() != null) {
            criteria.andLatitudeEqualTo(baseAreas.getLatitude());
        }
        if (baseAreas.getTypeAreas() != null) {
            criteria.andTypeAreasEqualTo(baseAreas.getTypeAreas());
        }
        if (baseAreas.getSign() != null) {
            criteria.andSignEqualTo(baseAreas.getSign());
        }
        if (baseAreas.getSort() != null) {
            criteria.andSortEqualTo(baseAreas.getSort());
        }
        if (baseAreas.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(baseAreas.getCreateTime());
        }
        if (baseAreas.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(baseAreas.getUpdateTime());
        }
        if (baseAreas.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(baseAreas.getIsDeleted());
        }
        return example;
    }

}
