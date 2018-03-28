package com.legend.cloud.vo.campus;

import com.legend.cloud.entity.campus.CampusTeacher;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 教师表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusTeacherVO extends AbstractVO<CampusTeacher> {
    private static final long serialVersionUID = 1L;

    /**
     * 教师id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 认证资格数量
     */
    private Integer verifyNum;
    /**
     *
     */
    private Boolean isEnabled;
    /**
     * 课程参与量
     */
    private Integer orderJoin;
    /**
     * 课程发布量
     */
    private Integer orderPublish;
    /**
     * 课程完成量
     */
    private Integer orderFinish;
    /**
     * 教学完成率
     */
    private Double percentageComplete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

    @Override
    public CampusTeacher parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusTeacherVO parseFrom(CampusTeacher campusTeacher, String... ignoreProperties) {
        return (CampusTeacherVO) super.parseFrom(campusTeacher, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusTeacherVO{" +
                ", id=" + getId() +
                ", userId=" + getUserId() +
                ", verifyNum=" + getVerifyNum() +
                ", isEnabled=" + getIsEnabled() +
                ", orderJoin=" + getOrderJoin() +
                ", orderPublish=" + getOrderPublish() +
                ", orderFinish=" + getOrderFinish() +
                ", percentageComplete=" + getPercentageComplete() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
