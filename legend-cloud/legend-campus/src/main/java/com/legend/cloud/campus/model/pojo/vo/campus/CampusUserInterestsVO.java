package com.legend.cloud.campus.model.pojo.vo.campus;

import com.legend.cloud.campus.model.pojo.entity.campus.CampusUserInterests;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 用户-兴趣标签
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CampusUserInterestsVO extends AbstractVO<CampusUserInterests, CampusUserInterestsVO> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 兴趣标签id
     */
    private Integer interestsId;
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

}
