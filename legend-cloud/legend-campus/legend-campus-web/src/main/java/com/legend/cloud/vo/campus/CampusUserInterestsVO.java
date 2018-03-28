package com.legend.cloud.vo.campus;

import com.legend.cloud.entity.campus.CampusUserInterests;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 用户-兴趣标签
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusUserInterestsVO extends AbstractVO<CampusUserInterests> {
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

    @Override
    public CampusUserInterests parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusUserInterestsVO parseFrom(CampusUserInterests campusUserInterests, String... ignoreProperties) {
        return (CampusUserInterestsVO) super.parseFrom(campusUserInterests, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusUserInterestsVO{" +
                ", id=" + getId() +
                ", userId=" + getUserId() +
                ", interestsId=" + getInterestsId() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
