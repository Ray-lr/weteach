package com.legend.cloud.service.campus.impl;

import com.legend.cloud.dao.mapper.campus.CampusInterestsMapper;
import com.legend.cloud.entity.campus.CampusInterests;
import com.legend.cloud.entity.campus.CampusInterestsExample;
import com.legend.cloud.service.campus.CampusInterestsService;
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
public class CampusInterestsServiceImpl extends AbstractLegendService<CampusInterests> implements CampusInterestsService {

    @Resource
    private CampusInterestsMapper campusInterestsMapper;

    @Override
    public Mapper<CampusInterests> getMapper() {
        return campusInterestsMapper;
    }

    @Override
    protected Object getExample(CampusInterests campusInterests, String order, String sort) {
        CampusInterestsExample example = new CampusInterestsExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusInterestsExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusInterests == null) {
            return example;
        }

        if (campusInterests.getId() != null) {
            criteria.andIdEqualTo(campusInterests.getId());
        }
        if (campusInterests.getName() != null) {
            criteria.andNameEqualTo(campusInterests.getName());
        }
        if (campusInterests.getDescription() != null) {
            criteria.andDescriptionEqualTo(campusInterests.getDescription());
        }
        if (campusInterests.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusInterests.getCreateTime());
        }
        if (campusInterests.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusInterests.getUpdateTime());
        }
        if (campusInterests.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusInterests.getIsDeleted());
        }
        return example;
    }

}
