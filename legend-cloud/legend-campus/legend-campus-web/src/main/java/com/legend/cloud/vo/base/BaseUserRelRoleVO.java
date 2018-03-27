package com.legend.cloud.vo.base;

        import com.legend.cloud.entity.base.BaseUserRelRole;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 用户角色关联
 *
 * @author hupeiD
 * @date 2018-03-27 21:30:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseUserRelRoleVO extends AbstractVO<BaseUserRelRole> {
    private static final long serialVersionUID = 1L;

            /**
         * 用户角色关联id
         */
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
    
    @Override
    public BaseUserRelRole parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseUserRelRoleVO parseFrom(BaseUserRelRole baseUserRelRole, String... ignoreProperties) {
        return (BaseUserRelRoleVO) super.parseFrom(baseUserRelRole, ignoreProperties);
    }

    @Override
    public String toString() {
        return "BaseUserRelRoleVO{" +
                                ", id=" + getId() +
                                ", baseUserId=" + getBaseUserId() +
                                ", systemRoleId=" + getSystemRoleId() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
