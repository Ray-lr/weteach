package com.legend.cloud.dao.mapper.campus;

import com.legend.cloud.entity.campus.CampusCourseCategory;
import com.legend.cloud.entity.campus.CampusCourseCategoryExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusCourseCategory的mapper接口
 *
 * @author hupeiD
 * @date 2018-04-10 22:28:00
 */
@Mapper
@Component
public interface CampusCourseCategoryMapper extends LegendMapper<CampusCourseCategory> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusCourseCategoryExample example);
}