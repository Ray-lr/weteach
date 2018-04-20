package com.legend.cloud.campus.model.pojo.vo.campus;

import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLimit;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 课程限制
 *
 * @author Jim
 * @date 2018-04-06 11:13:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CampusCourseLimitVO extends AbstractVO<CampusCourseLimit, CampusCourseLimitVO> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 课程id
     */
    private Integer courseId;
    /**
     * 系别限制
     */
    private Integer dept;
    /**
     * 专业限制
     */
    private Integer major;
    /**
     * 性别限制
     */
    private Integer sex;
    /**
     * 年级限制
     */
    private char[] grade;
    /**
     * 人数上限
     */
    private Integer personUpper;
    /**
     * 人数下限
     */
    private Integer personLower;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

    @Override
    public CampusCourseLimit parseTo(String... ignoreProperties) {
        CampusCourseLimit campusCourseLimit = super.parseTo(ignoreProperties);
        campusCourseLimit.setGrade(this.grade != null ? Integer.valueOf(Arrays.toString(this.grade)) : null);
        return campusCourseLimit;
    }

    @Override
    public CampusCourseLimitVO parseFrom(CampusCourseLimit campusCourseLimit, String... ignoreProperties) {
        CampusCourseLimitVO campusCourseLimitVO = super.parseFrom(campusCourseLimit,
                ignoreProperties);
        campusCourseLimitVO.setGrade(String.valueOf(campusCourseLimit.getGrade()).toCharArray());
        return campusCourseLimitVO;
    }

    @Override
    public List<CampusCourseLimitVO> parseFrom(List<CampusCourseLimit> campusCourseLimits, String... ignoreProperties) {
        return campusCourseLimits.stream().map(entity -> {
            CampusCourseLimitVO campusCourseLimitVO = new CampusCourseLimitVO();
            BeanUtils.copyProperties(entity, campusCourseLimitVO, ignoreProperties);
            campusCourseLimitVO.setGrade(entity.getGrade() != null ? String.valueOf(entity.getGrade()).toCharArray() : null);
            return campusCourseLimitVO;
        }).collect(Collectors.toList());
    }
}
