package com.legend.cloud.campus.service.system.impl;

import com.legend.cloud.campus.dao.mapper.system.SystemMenuRelPermissionMapper;
import com.legend.cloud.campus.model.pojo.entity.system.SystemMenuRelPermission;
import com.legend.cloud.campus.model.pojo.entity.system.example.SystemMenuRelPermissionExample;
import com.legend.cloud.campus.service.system.SystemMenuRelPermissionService;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

/**
 * @author hupeiD
 * @date 2018-04-12 10:59:34
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemMenuRelPermissionServiceImpl extends AbstractLegendService<SystemMenuRelPermission> implements SystemMenuRelPermissionService {

    @Resource
    private SystemMenuRelPermissionMapper systemMenuRelPermissionMapper;

    @Override
    public Mapper<SystemMenuRelPermission> getMapper() {
        return systemMenuRelPermissionMapper;
    }

    @Override
    protected Object getExample(SystemMenuRelPermission systemMenuRelPermission, String order, String sort) {
        SystemMenuRelPermissionExample example = new SystemMenuRelPermissionExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        SystemMenuRelPermissionExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (systemMenuRelPermission == null) {
            return example;
        }

        if (systemMenuRelPermission.getId() != null) {
            criteria.andIdEqualTo(systemMenuRelPermission.getId());
        }
        if (systemMenuRelPermission.getSystemMenuId() != null) {
            criteria.andSystemMenuIdEqualTo(systemMenuRelPermission.getSystemMenuId());
        }
        if (systemMenuRelPermission.getSystemPermissionId() != null) {
            criteria.andSystemPermissionIdEqualTo(systemMenuRelPermission.getSystemPermissionId());
        }
        if (systemMenuRelPermission.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(systemMenuRelPermission.getCreateTime());
        }
        if (systemMenuRelPermission.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(systemMenuRelPermission.getUpdateTime());
        }
        if (systemMenuRelPermission.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(systemMenuRelPermission.getIsDeleted());
        }
        return example;
    }

}
