package com.legend.cloud.service.campus.impl;

        import com.legend.cloud.dao.mapper.campus.CampusCourseLimitMapper;
        import com.legend.cloud.entity.campus.CampusCourseLimit;
        import com.legend.cloud.entity.campus.CampusCourseLimitExample;
        import com.legend.cloud.service.campus.CampusCourseLimitService;
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
public class CampusCourseLimitServiceImpl extends AbstractLegendService<CampusCourseLimit> implements CampusCourseLimitService {

    @Resource
    private CampusCourseLimitMapper campusCourseLimitMapper;

    @Override
    public Mapper<CampusCourseLimit> getMapper() {
        return campusCourseLimitMapper;
    }

    @Override
    protected Object getExample(CampusCourseLimit campusCourseLimit, String order, String sort) {
            CampusCourseLimitExample example = new CampusCourseLimitExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
            CampusCourseLimitExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusCourseLimit ==null){
            return example;
        }

                    if (campusCourseLimit.getId() != null){
            criteria.andIdEqualTo(campusCourseLimit.getId());
        }
                    if (campusCourseLimit.getCourseId() != null){
            criteria.andCourseIdEqualTo(campusCourseLimit.getCourseId());
        }
                    if (campusCourseLimit.getDept() != null){
            criteria.andDeptEqualTo(campusCourseLimit.getDept());
        }
                    if (campusCourseLimit.getMajor() != null){
            criteria.andMajorEqualTo(campusCourseLimit.getMajor());
        }
                    if (campusCourseLimit.getSex() != null){
            criteria.andSexEqualTo(campusCourseLimit.getSex());
        }
                    if (campusCourseLimit.getGrade() != null){
            criteria.andGradeEqualTo(campusCourseLimit.getGrade());
        }
                    if (campusCourseLimit.getCreateTime() != null){
            criteria.andCreateTimeEqualTo(campusCourseLimit.getCreateTime());
        }
                    if (campusCourseLimit.getUpdateTime() != null){
            criteria.andUpdateTimeEqualTo(campusCourseLimit.getUpdateTime());
        }
                    if (campusCourseLimit.getIsDeleted() != null){
            criteria.andIsDeletedEqualTo(campusCourseLimit.getIsDeleted());
        }
                return example;
    }

}
