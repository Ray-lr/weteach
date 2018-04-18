package com.legend.cloud.campus.dao.mapper.campus;


import com.legend.cloud.campus.model.pojo.entity.campus.CampusEvaluate;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusEvaluateExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusEvaluate的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:52
 */
@Mapper
@Component
public interface CampusEvaluateMapper extends LegendMapper<CampusEvaluate> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusEvaluateExample example);
}