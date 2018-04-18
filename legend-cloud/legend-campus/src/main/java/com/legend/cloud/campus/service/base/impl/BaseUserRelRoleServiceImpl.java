package com.legend.cloud.campus.service.base.impl;

import com.legend.cloud.campus.dao.mapper.base.BaseUserRelRoleMapper;
import com.legend.cloud.campus.model.pojo.entity.base.BaseUserRelRole;
import com.legend.cloud.campus.model.pojo.entity.base.BaseUserRelRoleExample;
import com.legend.cloud.campus.service.base.BaseUserRelRoleService;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BaseUserRelRoleServiceImpl extends AbstractLegendService<BaseUserRelRole> implements BaseUserRelRoleService {

    @Resource
    private BaseUserRelRoleMapper baseUserRelRoleMapper;

    @Override
    public Mapper<BaseUserRelRole> getMapper() {
        return baseUserRelRoleMapper;
    }

    @Override
    protected Object getExample(BaseUserRelRole baseUserRelRole, String order, String sort) {
        BaseUserRelRoleExample example = new BaseUserRelRoleExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        BaseUserRelRoleExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (baseUserRelRole == null) {
            return example;
        }

        if (baseUserRelRole.getId() != null) {
            criteria.andIdEqualTo(baseUserRelRole.getId());
        }
        if (baseUserRelRole.getBaseUserId() != null) {
            criteria.andBaseUserIdEqualTo(baseUserRelRole.getBaseUserId());
        }
        if (baseUserRelRole.getSystemRoleId() != null) {
            criteria.andSystemRoleIdEqualTo(baseUserRelRole.getSystemRoleId());
        }
        if (baseUserRelRole.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(baseUserRelRole.getCreateTime());
        }
        if (baseUserRelRole.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(baseUserRelRole.getUpdateTime());
        }
        if (baseUserRelRole.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(baseUserRelRole.getIsDeleted());
        }
        return example;
    }

    @Override
    public List<BaseUserRelRole> getListByUserId(Integer userId) {
        BaseUserRelRole baseUserRelRole = new BaseUserRelRole();
        baseUserRelRole.setBaseUserId(userId);
        baseUserRelRole.setIsDeleted(false);
        return getList(baseUserRelRole);
    }
}
