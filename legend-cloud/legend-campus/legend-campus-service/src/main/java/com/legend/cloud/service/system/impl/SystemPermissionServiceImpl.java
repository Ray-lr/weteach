package com.legend.cloud.service.system.impl;

        import com.legend.cloud.dao.mapper.system.SystemPermissionMapper;
        import com.legend.cloud.entity.system.SystemPermission;
        import com.legend.cloud.entity.system.SystemPermissionExample;
        import com.legend.cloud.service.system.SystemPermissionService;
        import com.legend.module.core.service.core.impl.AbstractLegendService;
        import org.apache.commons.lang.StringUtils;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import tk.mybatis.mapper.common.Mapper;

        import javax.annotation.Resource;
        import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemPermissionServiceImpl extends AbstractLegendService<SystemPermission> implements SystemPermissionService {

    @Resource
    private SystemPermissionMapper systemPermissionMapper;

    @Override
    public Mapper<SystemPermission> getMapper() {
        return systemPermissionMapper;
    }

    @Override
    protected Object getExample(SystemPermission systemPermission, String order, String sort) {
            SystemPermissionExample example = new SystemPermissionExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
            SystemPermissionExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (systemPermission ==null){
            return example;
        }

                    if (systemPermission.getId() != null){
            criteria.andIdEqualTo(systemPermission.getId());
        }
                    if (systemPermission.getPermissionName() != null){
            criteria.andPermissionNameEqualTo(systemPermission.getPermissionName());
        }
                    if (systemPermission.getSign() != null){
            criteria.andSignEqualTo(systemPermission.getSign());
        }
                    if (systemPermission.getDescription() != null){
            criteria.andDescriptionEqualTo(systemPermission.getDescription());
        }
                    if (systemPermission.getCreateTime() != null){
            criteria.andCreateTimeEqualTo(systemPermission.getCreateTime());
        }
                    if (systemPermission.getUpdateTime() != null){
            criteria.andUpdateTimeEqualTo(systemPermission.getUpdateTime());
        }
                    if (systemPermission.getIsDeleted() != null){
            criteria.andIsDeletedEqualTo(systemPermission.getIsDeleted());
        }
                return example;
    }

    @Override
    public List<SystemPermission> getListByPermissionIds(List<Integer> ids) {
        SystemPermissionExample example = new SystemPermissionExample();
        SystemPermissionExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return getListByExample(example);
    }
}
