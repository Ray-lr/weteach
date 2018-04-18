package com.legend.cloud.campus.service.system.impl;


import com.legend.cloud.campus.dao.mapper.system.SystemUserMapper;
import com.legend.cloud.campus.model.pojo.entity.system.SystemUser;
import com.legend.cloud.campus.model.pojo.entity.system.example.SystemUserExample;
import com.legend.cloud.campus.service.system.SystemUserService;
import com.legend.module.core.service.user.impl.AbstractUserService;
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
public class SystemUserServiceImpl extends AbstractUserService<SystemUser> implements SystemUserService {

    @Resource
    private SystemUserMapper systemUserMapper;

    @Override
    public Mapper<SystemUser> getMapper() {
        return systemUserMapper;
    }

    @Override
    protected Object getExample(SystemUser systemUser, String order, String sort) {
        SystemUserExample example = new SystemUserExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        SystemUserExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (systemUser == null) {
            return example;
        }

        if (systemUser.getId() != null) {
            criteria.andIdEqualTo(systemUser.getId());
        }
        if (systemUser.getUsername() != null) {
            criteria.andUsernameEqualTo(systemUser.getUsername());
        }
        if (systemUser.getPassword() != null) {
            criteria.andPasswordEqualTo(systemUser.getPassword());
        }
        if (systemUser.getPhone() != null) {
            criteria.andPhoneEqualTo(systemUser.getPhone());
        }
        if (systemUser.getNickName() != null) {
            criteria.andNickNameEqualTo(systemUser.getNickName());
        }
        if (systemUser.getLastLoginTime() != null) {
            criteria.andLastLoginTimeEqualTo(systemUser.getLastLoginTime());
        }
        if (systemUser.getIsEnabled() != null) {
            criteria.andIsEnabledEqualTo(systemUser.getIsEnabled());
        }
        if (systemUser.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(systemUser.getCreateTime());
        }
        if (systemUser.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(systemUser.getUpdateTime());
        }
        if (systemUser.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(systemUser.getIsDeleted());
        }
        return example;
    }

    @Override
    public SystemUser getByPhone(String phone) {
        SystemUser systemUser = new SystemUser();
        systemUser.setPhone(phone);
        return get(systemUser);
    }

    @Override
    public SystemUser getByUserName(String username) {
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(username);
        return get(systemUser);
    }

    @Override
    public SystemUser getByUsernameAndPassword(String username, String password) {
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(username);
        systemUser.setPassword(password);
        return get(systemUser);
    }
}
