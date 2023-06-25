package com.mashibing.dp.mybatisPlus.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
@ToString
@NoArgsConstructor
//@AllArgsConstructor
@TableName("teacher_info")
public class Teacher {
    @TableField("id")
    private Integer userId;
    @TableField("teachername")
    private String teacherName;
    @TableField("teacherid")
    private Integer teacherId;
    private String email;
    @TableField("phone")
    private String phoneNumber;
    private String subject;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher(Integer userId, String teacherName, Integer teacherId, String email, String phoneNumber, String subject) {
        this.userId = userId;
        this.teacherName = teacherName;
        this.teacherId = teacherId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.subject = subject;
    }

}
