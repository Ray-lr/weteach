package com.legend.cloud.service.system;

import com.legend.cloud.entity.system.SystemUserRelRole;
import com.legend.module.core.service.core.LegendService;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/8
 */
public interface SystemUserRelRoleService extends LegendService<SystemUserRelRole> {
    /**
     * 根据用户id获取所有用户角色关联记录
     *
     * @param userId 用户id
     * @return systemUserRelRoles
     */
    public List<SystemUserRelRole> getListByUserId(Integer userId);

}