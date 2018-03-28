package com.legend.cloud.dao.mapper.campus;

import com.legend.cloud.entity.campus.CampusCourseLimit;
import com.legend.cloud.entity.campus.CampusCourseLimitExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusCourseLimit的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:52
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