package com.legend.cloud.dao.mapper.system;

import com.legend.cloud.entity.system.SystemRoleRelPermission;
import com.legend.cloud.entity.system.SystemRoleRelPermissionExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * SystemRoleRelPermission的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:19:05
 */
@Mapper
@Component
public interface SystemRoleRelPermissionMapper extends LegendMapper<SystemRoleRelPermission> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(SystemRoleRelPermissionExample example);
}