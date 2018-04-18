package com.legend.cloud.campus.dao.mapper.campus;

import com.legend.cloud.campus.model.pojo.entity.campus.CampusAccount;
import com.legend.cloud.campus.model.pojo.entity.campus.example.CampusAccountExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusAccount的mapper接口
 *
 * @author hupeiD
 * @date 2018-04-18 22:41:20
 */
@Mapper
@Component
public interface CampusAccountMapper extends LegendMapper<CampusAccount> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusAccountExample example);
}