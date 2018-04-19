package com.legend.cloud.campus.model.pojo.vo.campus;

import com.legend.cloud.campus.model.pojo.entity.campus.CampusInterests;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 兴趣标签表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CampusInterestsVO extends AbstractVO<CampusInterests, CampusInterestsVO> {
    private static final long serialVersionUID = 1L;

    /**
     * 兴趣爱好id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;
}
