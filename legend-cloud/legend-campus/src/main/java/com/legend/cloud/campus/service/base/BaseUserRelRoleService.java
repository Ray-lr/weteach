package com.legend.cloud.campus.service.base;


import com.legend.cloud.campus.model.pojo.entity.base.BaseUserRelRole;
import com.legend.module.core.service.core.LegendService;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/8
 */
public interface BaseUserRelRoleService extends LegendService<BaseUserRelRole> {

    /**
     * 根据用户id获取所有用户角色关联记录
     *
     * @param userId 用户id
     * @return baseUserRelRoles
     */
    List<BaseUserRelRole> getListByUserId(Integer userId);
}