package com.legend.cloud.campus.service.campus.impl;

import com.legend.cloud.campus.dao.mapper.campus.CampusUserInterestsMapper;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusUserInterests;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusUserInterestsExample;
import com.legend.cloud.campus.service.campus.CampusUserInterestsService;
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
public class CampusUserInterestsServiceImpl extends AbstractLegendService<CampusUserInterests> implements CampusUserInterestsService {

    @Resource
    private CampusUserInterestsMapper campusUserInterestsMapper;

    @Override
    public Mapper<CampusUserInterests> getMapper() {
        return campusUserInterestsMapper;
    }

    @Override
    protected Object getExample(CampusUserInterests campusUserInterests, String order, String sort) {
        CampusUserInterestsExample example = new CampusUserInterestsExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusUserInterestsExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusUserInterests == null) {
            return example;
        }

        if (campusUserInterests.getId() != null) {
            criteria.andIdEqualTo(campusUserInterests.getId());
        }
        if (campusUserInterests.getUserId() != null) {
            criteria.andUserIdEqualTo(campusUserInterests.getUserId());
        }
        if (campusUserInterests.getInterestsId() != null) {
            criteria.andInterestsIdEqualTo(campusUserInterests.getInterestsId());
        }
        if (campusUserInterests.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusUserInterests.getCreateTime());
        }
        if (campusUserInterests.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusUserInterests.getUpdateTime());
        }
        if (campusUserInterests.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusUserInterests.getIsDeleted());
        }
        return example;
    }

}
