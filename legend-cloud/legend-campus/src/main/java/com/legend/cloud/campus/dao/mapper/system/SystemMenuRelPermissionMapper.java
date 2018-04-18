package com.legend.cloud.campus.dao.mapper.system;


import com.legend.cloud.campus.model.pojo.entity.system.SystemMenuRelPermission;
import com.legend.cloud.campus.model.pojo.entity.system.SystemMenuRelPermissionExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * SystemMenuRelPermission的mapper接口
 *
 * @author hupeiD
 * @date 2018-04-12 10:59:34
 */
@Mapper
@Component
public interface SystemMenuRelPermissionMapper extends LegendMapper<SystemMenuRelPermission> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(SystemMenuRelPermissionExample example);
}