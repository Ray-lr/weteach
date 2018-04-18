package com.legend.cloud.campus.dao.mapper.campus;


import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLimit;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLimitExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusCourseLimit的mapper接口
 *
 * @author Jim
 * @date 2018-04-06 11:13:08
 */
@Mapper
@Component
public interface CampusCourseLimitMapper extends LegendMapper<CampusCourseLimit> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusCourseLimitExample example);
}