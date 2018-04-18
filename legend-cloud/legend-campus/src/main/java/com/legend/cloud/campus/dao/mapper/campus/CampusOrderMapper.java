package com.legend.cloud.campus.dao.mapper.campus;


import com.legend.cloud.campus.model.pojo.entity.campus.CampusOrder;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusOrderExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusOrder的mapper接口
 *
 * @author Jim
 * @date 2018-04-09 22:11:52
 */
@Mapper
@Component
public interface CampusOrderMapper extends LegendMapper<CampusOrder> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusOrderExample example);
}