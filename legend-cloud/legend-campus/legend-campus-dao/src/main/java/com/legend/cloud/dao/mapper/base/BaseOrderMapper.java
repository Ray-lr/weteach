package com.legend.cloud.dao.mapper.base;

import com.legend.cloud.entity.base.BaseOrder;
import com.legend.cloud.entity.base.BaseOrderExample;
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