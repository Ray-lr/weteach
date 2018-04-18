package com.legend.cloud.campus.service.campus.impl;

import com.legend.cloud.campus.dao.mapper.campus.CampusAccountMapper;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusAccount;
import com.legend.cloud.campus.model.pojo.entity.campus.example.CampusAccountExample;
import com.legend.cloud.campus.service.campus.CampusAccountService;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

/**
 * @author hupeiD
 * @date 2018-04-18 22:41:20
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CampusAccountServiceImpl extends AbstractLegendService<CampusAccount> implements CampusAccountService {

    @Resource
    private CampusAccountMapper campusAccountMapper;

    @Override
    public Mapper<CampusAccount> getMapper() {
        return campusAccountMapper;
    }

    @Override
    protected Object getExample(CampusAccount campusAccount, String order, String sort) {
        CampusAccountExample example = new CampusAccountExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusAccountExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusAccount == null) {
            return example;
        }

        if (campusAccount.getId() != null) {
            criteria.andIdEqualTo(campusAccount.getId());
        }
        if (campusAccount.getUserId() != null) {
            criteria.andUserIdEqualTo(campusAccount.getUserId());
        }
        if (campusAccount.getName() != null) {
            criteria.andNameEqualTo(campusAccount.getName());
        }
        if (campusAccount.getNickname() != null) {
            criteria.andNicknameEqualTo(campusAccount.getNickname());
        }
        if (campusAccount.getAvatar() != null) {
            criteria.andAvatarEqualTo(campusAccount.getAvatar());
        }
        if (campusAccount.getSex() != null) {
            criteria.andSexEqualTo(campusAccount.getSex());
        }
        if (campusAccount.getBirthday() != null) {
            criteria.andBirthdayEqualTo(campusAccount.getBirthday());
        }
        if (campusAccount.getProvince() != null) {
            criteria.andProvinceEqualTo(campusAccount.getProvince());
        }
        if (campusAccount.getCity() != null) {
            criteria.andCityEqualTo(campusAccount.getCity());
        }
        if (campusAccount.getCounty() != null) {
            criteria.andCountyEqualTo(campusAccount.getCounty());
        }
        if (campusAccount.getEnrollmentYear() != null) {
            criteria.andEnrollmentYearEqualTo(campusAccount.getEnrollmentYear());
        }
        if (campusAccount.getDept() != null) {
            criteria.andDeptEqualTo(campusAccount.getDept());
        }
        if (campusAccount.getMajor() != null) {
            criteria.andMajorEqualTo(campusAccount.getMajor());
        }
        if (campusAccount.getDirection() != null) {
            criteria.andDirectionEqualTo(campusAccount.getDirection());
        }
        if (campusAccount.getPhone() != null) {
            criteria.andPhoneEqualTo(campusAccount.getPhone());
        }
        if (campusAccount.getEmail() != null) {
            criteria.andEmailEqualTo(campusAccount.getEmail());
        }
        if (campusAccount.getContact() != null) {
            criteria.andContactEqualTo(campusAccount.getContact());
        }
        if (campusAccount.getSignature() != null) {
            criteria.andSignatureEqualTo(campusAccount.getSignature());
        }
        if (campusAccount.getReputationRating() != null) {
            criteria.andReputationRatingEqualTo(campusAccount.getReputationRating());
        }
        if (campusAccount.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusAccount.getCreateTime());
        }
        if (campusAccount.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusAccount.getUpdateTime());
        }
        if (campusAccount.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusAccount.getIsDeleted());
        }
        return example;
    }

    @Override
    public CampusAccount getByUserId(Integer id) {
        if (id == null) {
            throw new NullPointerException();
        }
        CampusAccount campusAccount = new CampusAccount();
        campusAccount.setUserId(id);
        return get(campusAccount);
    }
}
