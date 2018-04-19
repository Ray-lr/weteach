package com.legend.cloud.campus.model.pojo.vo.system;

import com.legend.cloud.campus.model.pojo.entity.system.SystemPermission;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 系统权限
 *
 * @author hupeiD
 * @date 2018-03-27 21:30:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class SystemPermissionVO extends AbstractVO<SystemPermission, SystemPermissionVO> {
    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    private Integer id;
    /**
     * 权限名称
     */
    private String permissionName;
    /**
     * 标识
     */
    private String sign;
    /**
     * 描述
     */
    private String description;
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
