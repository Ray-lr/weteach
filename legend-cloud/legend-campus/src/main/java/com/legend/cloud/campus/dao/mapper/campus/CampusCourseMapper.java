package com.legend.cloud.campus.dao.mapper.campus;


import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourse;
import com.legend.cloud.campus.model.pojo.entity.campus.example.CampusCourseExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusCourse的mapper接口
 *
 * @author Jim
 * @date 2018-04-06 11:00:05
 */
@Mapper
@Component
public interface CampusCourseMapper extends LegendMapper<CampusCourse> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusCourseExample example);
}