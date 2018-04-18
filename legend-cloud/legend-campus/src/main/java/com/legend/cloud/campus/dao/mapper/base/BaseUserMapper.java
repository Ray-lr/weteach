package com.legend.cloud.campus.dao.mapper.base;


import com.legend.cloud.campus.model.pojo.entity.base.BaseUser;
import com.legend.cloud.campus.model.pojo.entity.base.BaseUserExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * BaseUser的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:52
 */
@Mapper
@Component
public interface BaseUserMapper extends LegendMapper<BaseUser> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(BaseUserExample example);
}