package com.example.redismybatisweb.dao;

import java.io.Serializable;
import java.util.Date;

public class UserBasic implements Serializable{
    private static final long serialVersionUID = 8567839088458797886L;
    private String id;

    private String telephone;

    private Date registTime;

    private String userCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserBasic{");
        sb.append("id='").append(id).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", registTime=").append(registTime);
        sb.append(", userCode='").append(userCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}