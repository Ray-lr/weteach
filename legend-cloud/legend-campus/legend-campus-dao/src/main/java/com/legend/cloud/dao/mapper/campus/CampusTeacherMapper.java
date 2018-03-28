package com.legend.cloud.dao.mapper.campus;

import com.legend.cloud.entity.campus.CampusTeacher;
import com.legend.cloud.entity.campus.CampusTeacherExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusTeacher的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:51
 */
@Mapper
@Component
public interface CampusTeacherMapper extends LegendMapper<CampusTeacher> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusTeacherExample example);
}