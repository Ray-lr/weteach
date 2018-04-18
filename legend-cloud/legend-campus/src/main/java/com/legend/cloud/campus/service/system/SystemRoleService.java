package com.legend.cloud.campus.service.system;


import com.legend.cloud.campus.model.pojo.entity.system.SystemRole;
import com.legend.module.core.service.core.LegendService;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/8
 */
public interface SystemRoleService extends LegendService<SystemRole> {
    /**
     * 根据角色id集合查询所有符合的角色
     *
     * @param ids id集合
     * @return systemRoles
     */
    List<SystemRole> getListByIds(List<Integer> ids);

}