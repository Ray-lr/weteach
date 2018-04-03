package com.legend.cloud.dao.mapper.campus;

import com.legend.cloud.entity.campus.CampusUserInfo;
import com.legend.cloud.entity.campus.CampusUserInfoExample;
import com.legend.module.core.dao.mapper.LegendMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * CampusUserInfo的mapper接口
 *
 * @author hupeiD
 * @date 2018-04-03 16:42:07
 */
@Mapper
@Component
public interface CampusUserInfoMapper extends LegendMapper<CampusUserInfo> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusUserInfoExample example);
}