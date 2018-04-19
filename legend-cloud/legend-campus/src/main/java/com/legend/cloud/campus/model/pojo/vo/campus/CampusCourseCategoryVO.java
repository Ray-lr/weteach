package com.legend.cloud.campus.model.pojo.vo.campus;

import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseCategory;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * 院系-专业-课程分类
 *
 * @author Jim
 * @date 2018-04-10 22:28:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CampusCourseCategoryVO extends AbstractVO<CampusCourseCategory, CampusCourseCategoryVO> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * 简称
     */
    private String abbreviation;
    /**
     * 相关描述
     */
    private String description;
    /**
     * 类型（1，院系；2，专业；3，课程）
     */
    private Integer typeCourseCategory;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

}
