package com.legend.cloud.campus.service.system.impl;

import com.legend.cloud.campus.dao.mapper.system.SystemUserRelRoleMapper;
import com.legend.cloud.campus.model.pojo.entity.system.SystemUserRelRole;
import com.legend.cloud.campus.model.pojo.entity.system.SystemUserRelRoleExample;
import com.legend.cloud.campus.service.system.SystemUserRelRoleService;
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
public class SystemUserRelRoleServiceImpl extends AbstractLegendService<SystemUserRelRole> implements SystemUserRelRoleService {

    @Resource
    private SystemUserRelRoleMapper systemUserRelRoleMapper;

    @Override
    public Mapper<SystemUserRelRole> getMapper() {
        return systemUserRelRoleMapper;
    }

    @Override
    protected Object getExample(SystemUserRelRole systemUserRelRole, String order, String sort) {
        SystemUserRelRoleExample example = new SystemUserRelRoleExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        SystemUserRelRoleExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (systemUserRelRole == null) {
            return example;
        }

        if (systemUserRelRole.getId() != null) {
            criteria.andIdEqualTo(systemUserRelRole.getId());
        }
        if (systemUserRelRole.getSystemUserId() != null) {
            criteria.andSystemUserIdEqualTo(systemUserRelRole.getSystemUserId());
        }
        if (systemUserRelRole.getSystemRoleId() != null) {
            criteria.andSystemRoleIdEqualTo(systemUserRelRole.getSystemRoleId());
        }
        if (systemUserRelRole.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(systemUserRelRole.getCreateTime());
        }
        if (systemUserRelRole.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(systemUserRelRole.getUpdateTime());
        }
        if (systemUserRelRole.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(systemUserRelRole.getIsDeleted());
        }
        return example;
    }

    @Override
    public List<SystemUserRelRole> getListByUserId(Integer userId) {
        SystemUserRelRole systemUserRelRole = new SystemUserRelRole();
        systemUserRelRole.setSystemUserId(userId);
        systemUserRelRole.setIsDeleted(false);
        return getList(systemUserRelRole);
    }

}
