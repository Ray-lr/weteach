package com.legend.cloud.campus.service.base.impl;

import com.legend.cloud.campus.dao.mapper.base.BaseLogRecordMapper;
import com.legend.cloud.campus.model.pojo.entity.base.BaseLogRecord;
import com.legend.cloud.campus.model.pojo.entity.base.example.BaseLogRecordExample;
import com.legend.cloud.campus.service.base.BaseLogRecordService;
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
public class BaseLogRecordServiceImpl extends AbstractLegendService<BaseLogRecord> implements BaseLogRecordService {

    @Resource
    private BaseLogRecordMapper baseLogRecordMapper;

    @Override
    public Mapper<BaseLogRecord> getMapper() {
        return baseLogRecordMapper;
    }

    @Override
    protected Object getExample(BaseLogRecord baseLogRecord, String order, String sort) {
        BaseLogRecordExample example = new BaseLogRecordExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        BaseLogRecordExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (baseLogRecord == null) {
            return example;
        }

        if (baseLogRecord.getId() != null) {
            criteria.andIdEqualTo(baseLogRecord.getId());
        }
        if (baseLogRecord.getUserId() != null) {
            criteria.andUserIdEqualTo(baseLogRecord.getUserId());
        }
        if (baseLogRecord.getContent() != null) {
            criteria.andContentEqualTo(baseLogRecord.getContent());
        }
        if (baseLogRecord.getTypeOption() != null) {
            criteria.andTypeOptionEqualTo(baseLogRecord.getTypeOption());
        }
        if (baseLogRecord.getTypeUser() != null) {
            criteria.andTypeUserEqualTo(baseLogRecord.getTypeUser());
        }
        if (baseLogRecord.getIp() != null) {
            criteria.andIpEqualTo(baseLogRecord.getIp());
        }
        if (baseLogRecord.getMethod() != null) {
            criteria.andMethodEqualTo(baseLogRecord.getMethod());
        }
        if (baseLogRecord.getExecuteTime() != null) {
            criteria.andExecuteTimeEqualTo(baseLogRecord.getExecuteTime());
        }
        if (baseLogRecord.getStatus() != null) {
            criteria.andStatusEqualTo(baseLogRecord.getStatus());
        }
        if (baseLogRecord.getRemark() != null) {
            criteria.andRemarkEqualTo(baseLogRecord.getRemark());
        }
        if (baseLogRecord.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(baseLogRecord.getCreateTime());
        }
        if (baseLogRecord.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(baseLogRecord.getUpdateTime());
        }
        if (baseLogRecord.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(baseLogRecord.getIsDeleted());
        }
        return example;
    }

}
