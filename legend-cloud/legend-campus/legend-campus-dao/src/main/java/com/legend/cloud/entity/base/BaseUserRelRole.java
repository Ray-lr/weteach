package com.legend.cloud.entity.base;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 用户角色关联
 *
 * @author hupeiD
 * @date 2018-03-27 21:30:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_user_rel_role")
public class BaseUserRelRole extends AbstractEntity<BaseUserRelRole> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户角色关联id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户id
     */
    private Integer baseUserId;
    /**
     * 系统角色id
     */
    private Integer systemRoleId;
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
