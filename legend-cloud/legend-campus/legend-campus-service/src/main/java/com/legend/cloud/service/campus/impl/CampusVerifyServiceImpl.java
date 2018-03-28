package com.legend.cloud.service.campus.impl;

import com.legend.cloud.dao.mapper.campus.CampusVerifyMapper;
import com.legend.cloud.entity.campus.CampusVerify;
import com.legend.cloud.entity.campus.CampusVerifyExample;
import com.legend.cloud.service.campus.CampusVerifyService;
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
public class CampusVerifyServiceImpl extends AbstractLegendService<CampusVerify> implements CampusVerifyService {

    @Resource
    private CampusVerifyMapper campusVerifyMapper;

    @Override
    public Mapper<CampusVerify> getMapper() {
        return campusVerifyMapper;
    }

    @Override
    protected Object getExample(CampusVerify campusVerify, String order, String sort) {
        CampusVerifyExample example = new CampusVerifyExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusVerifyExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusVerify == null) {
            return example;
        }

        if (campusVerify.getId() != null) {
            criteria.andIdEqualTo(campusVerify.getId());
        }
        if (campusVerify.getUserId() != null) {
            criteria.andUserIdEqualTo(campusVerify.getUserId());
        }
        if (campusVerify.getDept() != null) {
            criteria.andDeptEqualTo(campusVerify.getDept());
        }
        if (campusVerify.getMajor() != null) {
            criteria.andMajorEqualTo(campusVerify.getMajor());
        }
        if (campusVerify.getReason() != null) {
            criteria.andReasonEqualTo(campusVerify.getReason());
        }
        if (campusVerify.getEvidence() != null) {
            criteria.andEvidenceEqualTo(campusVerify.getEvidence());
        }
        if (campusVerify.getStatus() != null) {
            criteria.andStatusEqualTo(campusVerify.getStatus());
        }
        if (campusVerify.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusVerify.getCreateTime());
        }
        if (campusVerify.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusVerify.getUpdateTime());
        }
        if (campusVerify.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusVerify.getIsDeleted());
        }
        return example;
    }

}
