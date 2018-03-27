package com.legend.cloud.vo.system;

        import com.legend.cloud.entity.system.SystemPermission;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 系统权限
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemPermissionVO extends AbstractVO<SystemPermission> {
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
         * 资源
         */
        private String url;
            /**
         * 父级权限id
         */
        private Integer parentId;
            /**
         * 排序
         */
        private Integer sort;
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
    public SystemPermission parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public SystemPermissionVO parseFrom(SystemPermission systemPermission, String... ignoreProperties) {
        return (SystemPermissionVO) super.parseFrom(systemPermission, ignoreProperties);
    }

    @Override
    public String toString() {
        return "SystemPermissionVO{" +
                                ", id=" + getId() +
                                ", permissionName=" + getPermissionName() +
                                ", sign=" + getSign() +
                                ", description=" + getDescription() +
                                ", url=" + getUrl() +
                                ", parentId=" + getParentId() +
                                ", sort=" + getSort() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
