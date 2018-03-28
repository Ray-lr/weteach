package com.legend.cloud.service.campus.impl;

import com.legend.cloud.dao.mapper.campus.CampusTeacherMapper;
import com.legend.cloud.entity.campus.CampusTeacher;
import com.legend.cloud.entity.campus.CampusTeacherExample;
import com.legend.cloud.service.campus.CampusTeacherService;
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
public class CampusTeacherServiceImpl extends AbstractLegendService<CampusTeacher> implements CampusTeacherService {

    @Resource
    private CampusTeacherMapper campusTeacherMapper;

    @Override
    public Mapper<CampusTeacher> getMapper() {
        return campusTeacherMapper;
    }

    @Override
    protected Object getExample(CampusTeacher campusTeacher, String order, String sort) {
        CampusTeacherExample example = new CampusTeacherExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusTeacherExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusTeacher == null) {
            return example;
        }

        if (campusTeacher.getId() != null) {
            criteria.andIdEqualTo(campusTeacher.getId());
        }
        if (campusTeacher.getUserId() != null) {
            criteria.andUserIdEqualTo(campusTeacher.getUserId());
        }
        if (campusTeacher.getVerifyNum() != null) {
            criteria.andVerifyNumEqualTo(campusTeacher.getVerifyNum());
        }
        if (campusTeacher.getIsEnabled() != null) {
            criteria.andIsEnabledEqualTo(campusTeacher.getIsEnabled());
        }
        if (campusTeacher.getOrderJoin() != null) {
            criteria.andOrderJoinEqualTo(campusTeacher.getOrderJoin());
        }
        if (campusTeacher.getOrderPublish() != null) {
            criteria.andOrderPublishEqualTo(campusTeacher.getOrderPublish());
        }
        if (campusTeacher.getOrderFinish() != null) {
            criteria.andOrderFinishEqualTo(campusTeacher.getOrderFinish());
        }
        if (campusTeacher.getPercentageComplete() != null) {
            criteria.andPercentageCompleteEqualTo(campusTeacher.getPercentageComplete());
        }
        if (campusTeacher.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusTeacher.getCreateTime());
        }
        if (campusTeacher.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusTeacher.getUpdateTime());
        }
        if (campusTeacher.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusTeacher.getIsDeleted());
        }
        return example;
    }

}
