package com.legend.cloud.service.system.impl;

import com.legend.cloud.dao.mapper.system.SystemRoleRelPermissionMapper;
import com.legend.cloud.entity.system.SystemRoleRelPermission;
import com.legend.cloud.entity.system.SystemRoleRelPermissionExample;
import com.legend.cloud.service.system.SystemRoleRelPermissionService;
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
public class SystemRoleRelPermissionServiceImpl extends AbstractLegendService<SystemRoleRelPermission> implements SystemRoleRelPermissionService {

    @Resource
    private SystemRoleRelPermissionMapper systemRoleRelPermissionMapper;

    @Override
    public Mapper<SystemRoleRelPermission> getMapper() {
        return systemRoleRelPermissionMapper;
    }

    @Override
    protected Object getExample(SystemRoleRelPermission systemRoleRelPermission, String order, String sort) {
        SystemRoleRelPermissionExample example = new SystemRoleRelPermissionExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        SystemRoleRelPermissionExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (systemRoleRelPermission == null) {
            return example;
        }

        if (systemRoleRelPermission.getId() != null) {
            criteria.andIdEqualTo(systemRoleRelPermission.getId());
        }
        if (systemRoleRelPermission.getRoleId() != null) {
            criteria.andRoleIdEqualTo(systemRoleRelPermission.getRoleId());
        }
        if (systemRoleRelPermission.getPermissionId() != null) {
            criteria.andPermissionIdEqualTo(systemRoleRelPermission.getPermissionId());
        }
        if (systemRoleRelPermission.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(systemRoleRelPermission.getCreateTime());
        }
        if (systemRoleRelPermission.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(systemRoleRelPermission.getUpdateTime());
        }
        if (systemRoleRelPermission.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(systemRoleRelPermission.getIsDeleted());
        }
        return example;
    }

    @Override
    public List<SystemRoleRelPermission> getListByRoleIds(List<Integer> ids) {
        SystemRoleRelPermissionExample example = new SystemRoleRelPermissionExample();
        SystemRoleRelPermissionExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        criteria.andRoleIdIn(ids);
        return getListByExample(example);
    }

}
