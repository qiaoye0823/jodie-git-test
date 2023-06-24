package com.jodie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private Integer type; // 0-普通用户，1-超级管理员，2-版主
    private Integer status; // 0-未激活，1-已激活
    private String activationCode;
    private String headerUrl;
    private Date createTime;


}
