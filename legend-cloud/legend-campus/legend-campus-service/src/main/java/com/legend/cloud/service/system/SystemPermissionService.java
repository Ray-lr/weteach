package com.legend.cloud.service.system;

import com.legend.cloud.entity.system.SystemPermission;
import com.legend.module.core.service.core.LegendService;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/8
 */
public interface SystemPermissionService extends LegendService<SystemPermission> {
    /**
     * 根据权限ids获得所有权限
     *
     * @param ids 权限ids
     * @return systemPermissions
     */
    public List<SystemPermission> getListByPermissionIds(List<Integer> ids);

}