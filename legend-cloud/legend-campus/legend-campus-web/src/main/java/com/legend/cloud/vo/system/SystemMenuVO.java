package com.legend.cloud.vo.system;

        import com.legend.cloud.entity.system.SystemMenu;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 菜单表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemMenuVO extends AbstractVO<SystemMenu> {
    private static final long serialVersionUID = 1L;

            /**
         * 
         */
        private Integer id;
            /**
         * 菜单名称
         */
        private String name;
            /**
         * url
         */
        private String url;
            /**
         * 描述
         */
        private String description;
            /**
         * 菜单等级
         */
        private Integer level;
            /**
         * 父级id
         */
        private Integer parentId;
            /**
         * 排序
         */
        private Integer sort;
            /**
         * 额外添加的类
         */
        private String className;
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
    public SystemMenu parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public SystemMenuVO parseFrom(SystemMenu systemMenu, String... ignoreProperties) {
        return (SystemMenuVO) super.parseFrom(systemMenu, ignoreProperties);
    }

    @Override
    public String toString() {
        return "SystemMenuVO{" +
                                ", id=" + getId() +
                                ", name=" + getName() +
                                ", url=" + getUrl() +
                                ", description=" + getDescription() +
                                ", level=" + getLevel() +
                                ", parentId=" + getParentId() +
                                ", sort=" + getSort() +
                                ", className=" + getClassName() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
