package com.legend.cloud.campus.dao.mapper.base;


import com.legend.cloud.campus.model.pojo.entity.base.BaseOrder;
import com.legend.cloud.campus.model.pojo.entity.base.example.BaseOrderExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * BaseOrder的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:50
 */
@Mapper
@Component
public interface BaseOrderMapper extends LegendMapper<BaseOrder> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(BaseOrderExample example);
}