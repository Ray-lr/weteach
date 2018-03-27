package com.legend.cloud.dao.mapper.system;

import com.legend.cloud.entity.system.SystemUserRelRole;
import com.legend.cloud.entity.system.SystemUserRelRoleExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * SystemUserRelRole的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:19:04
 */
@Mapper
@Component
public interface SystemUserRelRoleMapper extends LegendMapper<SystemUserRelRole> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(SystemUserRelRoleExample example);
}