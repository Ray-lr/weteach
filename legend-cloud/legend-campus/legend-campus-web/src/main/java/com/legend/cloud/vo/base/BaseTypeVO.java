package com.legend.cloud.vo.base;

        import com.legend.cloud.entity.base.BaseType;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 基础类型
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseTypeVO extends AbstractVO<BaseType> {
    private static final long serialVersionUID = 1L;

            /**
         * 基础类型id
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
         * 唯一标识
         */
        private String sign;
            /**
         * 数值
         */
        private String parameter;
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
    public BaseType parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseTypeVO parseFrom(BaseType baseType, String... ignoreProperties) {
        return (BaseTypeVO) super.parseFrom(baseType, ignoreProperties);
    }

    @Override
    public String toString() {
        return "BaseTypeVO{" +
                                ", id=" + getId() +
                                ", name=" + getName() +
                                ", description=" + getDescription() +
                                ", sign=" + getSign() +
                                ", parameter=" + getParameter() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
