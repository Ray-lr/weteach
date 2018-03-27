package com.legend.cloud.service.system.impl;

        import com.legend.cloud.dao.mapper.system.SystemMenuMapper;
        import com.legend.cloud.entity.system.SystemMenu;
        import com.legend.cloud.entity.system.SystemMenuExample;
        import com.legend.cloud.service.system.SystemMenuService;
        import com.legend.module.core.service.core.impl.AbstractLegendService;
        import org.apache.commons.lang.StringUtils;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import tk.mybatis.mapper.common.Mapper;

        import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2018/3/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemMenuServiceImpl extends AbstractLegendService<SystemMenu> implements SystemMenuService {

    @Resource
    private SystemMenuMapper systemMenuMapper;

    @Override
    public Mapper<SystemMenu> getMapper() {
        return systemMenuMapper;
    }

    @Override
    protected Object getExample(SystemMenu systemMenu, String order, String sort) {
            SystemMenuExample example = new SystemMenuExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
            SystemMenuExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (systemMenu ==null){
            return example;
        }

                    if (systemMenu.getId() != null){
            criteria.andIdEqualTo(systemMenu.getId());
        }
                    if (systemMenu.getName() != null){
            criteria.andNameEqualTo(systemMenu.getName());
        }
                    if (systemMenu.getUrl() != null){
            criteria.andUrlEqualTo(systemMenu.getUrl());
        }
                    if (systemMenu.getDescription() != null){
            criteria.andDescriptionEqualTo(systemMenu.getDescription());
        }
                    if (systemMenu.getLevel() != null){
            criteria.andLevelEqualTo(systemMenu.getLevel());
        }
                    if (systemMenu.getParentId() != null){
            criteria.andParentIdEqualTo(systemMenu.getParentId());
        }
                    if (systemMenu.getSort() != null){
            criteria.andSortEqualTo(systemMenu.getSort());
        }
                    if (systemMenu.getClassName() != null){
            criteria.andClassNameEqualTo(systemMenu.getClassName());
        }
                    if (systemMenu.getCreateTime() != null){
            criteria.andCreateTimeEqualTo(systemMenu.getCreateTime());
        }
                    if (systemMenu.getUpdateTime() != null){
            criteria.andUpdateTimeEqualTo(systemMenu.getUpdateTime());
        }
                    if (systemMenu.getIsDeleted() != null){
            criteria.andIsDeletedEqualTo(systemMenu.getIsDeleted());
        }
                return example;
    }

}
