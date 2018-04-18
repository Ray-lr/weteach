package com.legend.cloud.campus.dao.mapper.system;


import com.legend.cloud.campus.model.pojo.entity.system.SystemUser;
import com.legend.cloud.campus.model.pojo.entity.system.SystemUserExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * SystemUser的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:19:04
 */
@Mapper
@Component
public interface SystemUserMapper extends LegendMapper<SystemUser> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(SystemUserExample example);
}