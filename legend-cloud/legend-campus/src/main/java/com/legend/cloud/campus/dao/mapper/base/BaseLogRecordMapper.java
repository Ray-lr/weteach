package com.legend.cloud.campus.dao.mapper.base;


import com.legend.cloud.campus.model.pojo.entity.base.BaseLogRecord;
import com.legend.cloud.campus.model.pojo.entity.base.example.BaseLogRecordExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * BaseLogRecord的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:51
 */
@Mapper
@Component
public interface BaseLogRecordMapper extends LegendMapper<BaseLogRecord> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(BaseLogRecordExample example);
}