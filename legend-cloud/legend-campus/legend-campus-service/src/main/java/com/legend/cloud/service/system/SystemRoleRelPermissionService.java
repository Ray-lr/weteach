package com.legend.cloud.service.system;

import com.legend.cloud.entity.system.SystemRoleRelPermission;
import com.legend.module.core.service.core.LegendService;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/8
 */
public interface SystemRoleRelPermissionService extends LegendService<SystemRoleRelPermission> {
    /**
     * 根据角色ids查询所有角色权限关联记录
     *
     * @param ids 角色ids
     * @return systemRoleRelPermissions
     */
    public List<SystemRoleRelPermission> getListByRoleIds(List<Integer> ids);

}