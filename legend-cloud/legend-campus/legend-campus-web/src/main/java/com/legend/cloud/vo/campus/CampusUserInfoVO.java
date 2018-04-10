package com.legend.cloud.vo.campus;

import com.legend.cloud.entity.campus.CampusUserInfo;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 个人信息表
 *
 * @author Jim
 * @date 2018-04-10 13:45:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusUserInfoVO extends AbstractVO<CampusUserInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户基础id
     */
    private Integer baseUserId;
    /**
     * 用户实名
     */
    private String name;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生年月
     */
    private Date birthday;
    /**
     * 省/直辖市/自治区/特别行政区
     */
    private Integer province;
    /**
     * 市/自治州
     */
    private Integer city;
    /**
     * 县/区
     */
    private Integer county;
    /**
     * 入学年份
     */
    private String enrollmentYear;
    /**
     * 系别
     */
    private String dept;
    /**
     * 专业
     */
    private String major;
    /**
     * 方向
     */
    private String direction;
    /**
     * 电话
     */
    private String phone;
    /**
     * 联系方式（QQ,微信,邮箱）
     */
    private String contact;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 积分量
     */
    private Integer credits;
    /**
     * 积分信誉等级
     */
    private String creditsLevel;
    /**
     * 参与课程数
     */
    private Integer orderJoin;
    /**
     * 课程发布数
     */
    private Integer orderPublish;
    /**
     * 课程完成数
     */
    private Integer orderFinish;
    /**
     * 课程完成率
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
    public CampusUserInfo parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusUserInfoVO parseFrom(CampusUserInfo campusUserInfo, String... ignoreProperties) {
        return (CampusUserInfoVO) super.parseFrom(campusUserInfo, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusUserInfoVO{" +
                ", id=" + getId() +
                ", baseUserId=" + getBaseUserId() +
                ", name=" + getName() +
                ", nickname=" + getNickname() +
                ", sex=" + getSex() +
                ", birthday=" + getBirthday() +
                ", province=" + getProvince() +
                ", city=" + getCity() +
                ", county=" + getCounty() +
                ", enrollmentYear=" + getEnrollmentYear() +
                ", dept=" + getDept() +
                ", major=" + getMajor() +
                ", direction=" + getDirection() +
                ", phone=" + getPhone() +
                ", contact=" + getContact() +
                ", signature=" + getSignature() +
                ", credits=" + getCredits() +
                ", creditsLevel=" + getCreditsLevel() +
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
