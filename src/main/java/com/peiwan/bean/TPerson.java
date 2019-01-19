package com.peiwan.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
 *
<<<<<<< HEAD:src/main/java/com/peiwan/bean/TPerson.java
 * @author 
 * @since 2019-01-16
=======
>>>>>>> 9fb37ab764f9d72d5831f5bcbec6d7e6ae795c6e:src/main/java/com/peiwan/bean/TPerson.java
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
<<<<<<< HEAD:src/main/java/com/peiwan/bean/TPerson.java
=======
@TableName("t_person")
>>>>>>> 9fb37ab764f9d72d5831f5bcbec6d7e6ae795c6e:src/main/java/com/peiwan/bean/TPerson.java
public class TPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    /**
     * 昵称
     */
    private String personNickname;

    /**
     * 用户姓名
     */
    private String personName;

    /**
     * 密码
     */
    private String personPwd;

    /**
     * 密码加密
     */
    private String personPwdencry;

    /**
     * 电话
     */
    private String personTel;

    /**
     * 性别
     */
    private String personSex;

    /**
     * 出生日期
     */
    private String personBirthday;

    /**
     * qq
     */
    private Integer personQq;

    /**
     * 微信
     */
    private String personWeixin;

    /**
     * 头像
     */
    private String personImage;

    /**
     * 住址
     */
    private String personAdress;

    /**
     * 签名
     */
    private String personContent;

    /**
     * 身高
     */
    private String personHeight;

    /**
     * 体重
     */
    private String personWeight;

    /**
     * 职业
     */
    private String personCareer;

    /**
     * 学校
     */
    private String personSchool;

    /**
     * 兴趣
     */
    private String personInterest;

    /**
<<<<<<< HEAD:src/main/java/com/peiwan/bean/TPerson.java
     * 封面桌面
=======
     * 封面图片
>>>>>>> 9fb37ab764f9d72d5831f5bcbec6d7e6ae795c6e:src/main/java/com/peiwan/bean/TPerson.java
     */
    private String personCoverphoto;

    /**
     * 创建时间
     */
    private String personCreatetime;

    /**
     * 成为主播时间
     */
    private String personBecometime;

    /**
     * 标识(0用户1主播2管理员)
     */
    private Integer personFlate;

    /**
     * 用户申请状态(0未认证，正常)
     */
    private Integer personStatus;

    /**
     * 登录时间
     */
    private String personLogintime;

    /**
     * 修改(1)成为主播()
     */
    private Integer zZhubo;


}
