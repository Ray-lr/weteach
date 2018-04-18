package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 个人信息表
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "campus_user_info")
public class CampusUserInfo extends AbstractEntity<CampusUserInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户基础id
     */
    @Column(name = "base_user_id")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @Column(name = "enrollment_year")
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
     * 邮箱
     */
    private String email;
    /**
     * 联系方式（QQ,微信,等等）
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
    @Column(name = "credits_level")
    private String creditsLevel;
    /**
     * 参与课程数
     */
    @Column(name = "order_join")
    private Integer orderJoin;
    /**
     * 课程发布数
     */
    @Column(name = "order_publish")
    private Integer orderPublish;
    /**
     * 课程完成数
     */
    @Column(name = "order_finish")
    private Integer orderFinish;
    /**
     * 课程完成率
     */
    @Column(name = "percentage_complete")
    private Double percentageComplete;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
