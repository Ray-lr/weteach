package com.legend.cloud.service.campus.impl;

import com.legend.cloud.dao.mapper.campus.CampusUserInfoMapper;
import com.legend.cloud.entity.campus.CampusUserInfo;
import com.legend.cloud.entity.campus.CampusUserInfoExample;
import com.legend.cloud.service.campus.CampusUserInfoService;
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
public class CampusUserInfoServiceImpl extends AbstractLegendService<CampusUserInfo> implements CampusUserInfoService {

    @Resource
    private CampusUserInfoMapper campusUserInfoMapper;

    @Override
    public Mapper<CampusUserInfo> getMapper() {
        return campusUserInfoMapper;
    }

    @Override
    protected Object getExample(CampusUserInfo campusUserInfo, String order, String sort) {
        CampusUserInfoExample example = new CampusUserInfoExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusUserInfoExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusUserInfo == null) {
            return example;
        }

        if (campusUserInfo.getId() != null) {
            criteria.andIdEqualTo(campusUserInfo.getId());
        }
        if (campusUserInfo.getBaseUserId() != null) {
            criteria.andBaseUserIdEqualTo(campusUserInfo.getBaseUserId());
        }
        if (campusUserInfo.getName() != null) {
            criteria.andNameEqualTo(campusUserInfo.getName());
        }
        if (campusUserInfo.getNickname() != null) {
            criteria.andNicknameEqualTo(campusUserInfo.getNickname());
        }
        if (campusUserInfo.getSex() != null) {
            criteria.andSexEqualTo(campusUserInfo.getSex());
        }
        if (campusUserInfo.getBirthday() != null) {
            criteria.andBirthdayEqualTo(campusUserInfo.getBirthday());
        }
        if (campusUserInfo.getProvinces() != null) {
            criteria.andProvincesEqualTo(campusUserInfo.getProvinces());
        }
        if (campusUserInfo.getCities() != null) {
            criteria.andCitiesEqualTo(campusUserInfo.getCities());
        }
        if (campusUserInfo.getCountries() != null) {
            criteria.andCountriesEqualTo(campusUserInfo.getCountries());
        }
        if (campusUserInfo.getEnrollmentYear() != null) {
            criteria.andEnrollmentYearEqualTo(campusUserInfo.getEnrollmentYear());
        }
        if (campusUserInfo.getDept() != null) {
            criteria.andDeptEqualTo(campusUserInfo.getDept());
        }
        if (campusUserInfo.getMajor() != null) {
            criteria.andMajorEqualTo(campusUserInfo.getMajor());
        }
        if (campusUserInfo.getDirection() != null) {
            criteria.andDirectionEqualTo(campusUserInfo.getDirection());
        }
        if (campusUserInfo.getPhone() != null) {
            criteria.andPhoneEqualTo(campusUserInfo.getPhone());
        }
        if (campusUserInfo.getQicq() != null) {
            criteria.andQicqEqualTo(campusUserInfo.getQicq());
        }
        if (campusUserInfo.getEmail() != null) {
            criteria.andEmailEqualTo(campusUserInfo.getEmail());
        }
        if (campusUserInfo.getSignature() != null) {
            criteria.andSignatureEqualTo(campusUserInfo.getSignature());
        }
        if (campusUserInfo.getCredits() != null) {
            criteria.andCreditsEqualTo(campusUserInfo.getCredits());
        }
        if (campusUserInfo.getCreditsLevel() != null) {
            criteria.andCreditsLevelEqualTo(campusUserInfo.getCreditsLevel());
        }
        if (campusUserInfo.getOrderJoin() != null) {
            criteria.andOrderJoinEqualTo(campusUserInfo.getOrderJoin());
        }
        if (campusUserInfo.getOrderPublish() != null) {
            criteria.andOrderPublishEqualTo(campusUserInfo.getOrderPublish());
        }
        if (campusUserInfo.getOrderFinish() != null) {
            criteria.andOrderFinishEqualTo(campusUserInfo.getOrderFinish());
        }
        if (campusUserInfo.getPercentageComplete() != null) {
            criteria.andPercentageCompleteEqualTo(campusUserInfo.getPercentageComplete());
        }
        if (campusUserInfo.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusUserInfo.getCreateTime());
        }
        if (campusUserInfo.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusUserInfo.getUpdateTime());
        }
        if (campusUserInfo.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusUserInfo.getIsDeleted());
        }
        return example;
    }

}
