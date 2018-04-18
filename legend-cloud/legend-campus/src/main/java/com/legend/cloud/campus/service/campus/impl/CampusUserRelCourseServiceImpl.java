package com.legend.cloud.campus.service.campus.impl;

import com.legend.cloud.campus.dao.mapper.campus.CampusUserRelCourseMapper;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusUserRelCourse;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusUserRelCourseExample;
import com.legend.cloud.campus.service.campus.CampusUserRelCourseService;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

/**
 * @author hupeiD
 * @date 2018-04-12 20:27:22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CampusUserRelCourseServiceImpl extends AbstractLegendService<CampusUserRelCourse> implements CampusUserRelCourseService {

    @Resource
    private CampusUserRelCourseMapper campusUserRelCourseMapper;

    @Override
    public Mapper<CampusUserRelCourse> getMapper() {
        return campusUserRelCourseMapper;
    }

    @Override
    protected Object getExample(CampusUserRelCourse campusUserRelCourse, String order, String sort) {
        CampusUserRelCourseExample example = new CampusUserRelCourseExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusUserRelCourseExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusUserRelCourse == null) {
            return example;
        }

        if (campusUserRelCourse.getId() != null) {
            criteria.andIdEqualTo(campusUserRelCourse.getId());
        }
        if (campusUserRelCourse.getTypeUser() != null) {
            criteria.andTypeUserEqualTo(campusUserRelCourse.getTypeUser());
        }
        if (campusUserRelCourse.getUserId() != null) {
            criteria.andUserIdEqualTo(campusUserRelCourse.getUserId());
        }
        if (campusUserRelCourse.getCourseId() != null) {
            criteria.andCourseIdEqualTo(campusUserRelCourse.getCourseId());
        }
        if (campusUserRelCourse.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusUserRelCourse.getCreateTime());
        }
        if (campusUserRelCourse.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusUserRelCourse.getUpdateTime());
        }
        if (campusUserRelCourse.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusUserRelCourse.getIsDeleted());
        }
        return example;
    }

}
