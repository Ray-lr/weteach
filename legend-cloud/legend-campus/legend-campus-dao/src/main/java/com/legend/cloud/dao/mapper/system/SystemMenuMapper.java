package com.legend.cloud.dao.mapper.system;

        import com.legend.cloud.entity.system.SystemMenu;
        import com.legend.cloud.entity.system.SystemMenuExample;
        import com.legend.module.core.dao.mapper.LegendMapper;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Component;

/**
 * SystemMenu的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:19:01
 */
@Mapper
@Component
public interface SystemMenuMapper extends LegendMapper<SystemMenu> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(SystemMenuExample example);
}