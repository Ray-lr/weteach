package com.legend.cloud.campus.model.pojo.vo.system;

import com.legend.cloud.campus.model.pojo.entity.system.SystemRole;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 系统角色
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class SystemRoleVO extends AbstractVO<SystemRole, SystemRoleVO> {
    private static final long serialVersionUID = 1L;

    /**
     * 系统角色id
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 标识
     */
    private String sign;
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
