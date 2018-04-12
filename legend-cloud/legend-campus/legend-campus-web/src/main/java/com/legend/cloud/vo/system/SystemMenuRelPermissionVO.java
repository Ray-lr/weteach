package com.legend.cloud.vo.system;

import com.legend.cloud.entity.system.SystemMenuRelPermission;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 系统菜单权限关联表
 *
 * @author hupeiD
 * @date 2018-04-12 10:59:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class SystemMenuRelPermissionVO extends AbstractVO<SystemMenuRelPermission> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
    /**
     * 系统菜单表
     */
    private Integer systemMenuId;
    /**
     * 系统权限表
     */
    private Integer systemPermissionId;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

    @Override
    public SystemMenuRelPermission parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public SystemMenuRelPermissionVO parseFrom(SystemMenuRelPermission systemMenuRelPermission, String... ignoreProperties) {
        return (SystemMenuRelPermissionVO) super.parseFrom(systemMenuRelPermission, ignoreProperties);
    }

}
