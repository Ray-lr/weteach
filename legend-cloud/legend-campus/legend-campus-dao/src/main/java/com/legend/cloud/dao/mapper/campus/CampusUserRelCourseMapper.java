package com.legend.cloud.dao.mapper.campus;

import com.legend.cloud.entity.campus.CampusUserRelCourse;
import com.legend.cloud.entity.campus.CampusUserRelCourseExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusUserRelCourse的mapper接口
 *
 * @author hupeiD
 * @date 2018-04-12 20:27:22
 */
@Mapper
@Component
public interface CampusUserRelCourseMapper extends LegendMapper<CampusUserRelCourse> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusUserRelCourseExample example);
}