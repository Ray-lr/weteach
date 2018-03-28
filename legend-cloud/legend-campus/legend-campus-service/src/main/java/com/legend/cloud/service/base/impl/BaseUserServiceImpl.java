package com.legend.cloud.service.base.impl;

import com.legend.cloud.dao.mapper.base.BaseUserMapper;
import com.legend.cloud.entity.base.BaseUser;
import com.legend.cloud.entity.base.BaseUserExample;
import com.legend.cloud.service.base.BaseUserService;
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
public class BaseUserServiceImpl extends AbstractUserService<BaseUser> implements BaseUserService {

    @Resource
    private BaseUserMapper baseUserMapper;

    @Override
    public Mapper<BaseUser> getMapper() {
        return baseUserMapper;
    }

    @Override
    protected Object getExample(BaseUser baseUser, String order, String sort) {
        BaseUserExample example = new BaseUserExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        BaseUserExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (baseUser == null) {
            return example;
        }

        if (baseUser.getId() != null) {
            criteria.andIdEqualTo(baseUser.getId());
        }
        if (baseUser.getUsername() != null) {
            criteria.andUsernameEqualTo(baseUser.getUsername());
        }
        if (baseUser.getPassword() != null) {
            criteria.andPasswordEqualTo(baseUser.getPassword());
        }
        if (baseUser.getPhone() != null) {
            criteria.andPhoneEqualTo(baseUser.getPhone());
        }
        if (baseUser.getNickName() != null) {
            criteria.andNickNameEqualTo(baseUser.getNickName());
        }
        if (baseUser.getIsEnabled() != null) {
            criteria.andIsEnabledEqualTo(baseUser.getIsEnabled());
        }
        if (baseUser.getStatus() != null) {
            criteria.andStatusEqualTo(baseUser.getStatus());
        }
        if (baseUser.getLastLoginTime() != null) {
            criteria.andLastLoginTimeEqualTo(baseUser.getLastLoginTime());
        }
        if (baseUser.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(baseUser.getCreateTime());
        }
        if (baseUser.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(baseUser.getUpdateTime());
        }
        if (baseUser.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(baseUser.getIsDeleted());
        }
        return example;
    }

    @Override
    public BaseUser getByPhone(String phone) {
        BaseUser baseUser = new BaseUser();
        baseUser.setPhone(phone);
        return get(baseUser);
    }

    @Override
    public BaseUser getByUserName(String username) {
        BaseUser baseUser = new BaseUser();
        baseUser.setUsername(username);
        return get(baseUser);
    }

    @Override
    public BaseUser getByUsernameAndPassword(String username, String password) {
        BaseUser baseUser = new BaseUser();
        baseUser.setUsername(username);
        baseUser.setPassword(password);
        return get(baseUser);
    }
}
