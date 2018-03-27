package com.legend.cloud.service.base.impl;

        import com.legend.cloud.dao.mapper.base.BaseFileMapper;
        import com.legend.cloud.entity.base.BaseFile;
        import com.legend.cloud.entity.base.BaseFileExample;
        import com.legend.cloud.service.base.BaseFileService;
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
public class BaseFileServiceImpl extends AbstractLegendService<BaseFile> implements BaseFileService {

    @Resource
    private BaseFileMapper baseFileMapper;

    @Override
    public Mapper<BaseFile> getMapper() {
        return baseFileMapper;
    }

    @Override
    protected Object getExample(BaseFile baseFile, String order, String sort) {
            BaseFileExample example = new BaseFileExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
            BaseFileExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (baseFile ==null){
            return example;
        }

                    if (baseFile.getId() != null){
            criteria.andIdEqualTo(baseFile.getId());
        }
                    if (baseFile.getUserId() != null){
            criteria.andUserIdEqualTo(baseFile.getUserId());
        }
                    if (baseFile.getTypeUser() != null){
            criteria.andTypeUserEqualTo(baseFile.getTypeUser());
        }
                    if (baseFile.getTitle() != null){
            criteria.andTitleEqualTo(baseFile.getTitle());
        }
                    if (baseFile.getContent() != null){
            criteria.andContentEqualTo(baseFile.getContent());
        }
                    if (baseFile.getUrl() != null){
            criteria.andUrlEqualTo(baseFile.getUrl());
        }
                    if (baseFile.getFileName() != null){
            criteria.andFileNameEqualTo(baseFile.getFileName());
        }
                    if (baseFile.getCreateTime() != null){
            criteria.andCreateTimeEqualTo(baseFile.getCreateTime());
        }
                    if (baseFile.getUpdateTime() != null){
            criteria.andUpdateTimeEqualTo(baseFile.getUpdateTime());
        }
                    if (baseFile.getIsDeleted() != null){
            criteria.andIsDeletedEqualTo(baseFile.getIsDeleted());
        }
                return example;
    }

}
