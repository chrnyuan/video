package com.zhiyou.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userEmail;

    private String userPhone;

    private String userPassword;

    private String userNickname;

    private String userSex;

    private String userBithday;

    private String userAddress;

    private String userImgurl;

    private Date userCreatetime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserBithday() {
        return userBithday;
    }

    public void setUserBithday(String userBithday) {
        this.userBithday = userBithday == null ? null : userBithday.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserImgurl() {
        return userImgurl;
    }

    public void setUserImgurl(String userImgurl) {
        this.userImgurl = userImgurl == null ? null : userImgurl.trim();
    }

    public Date getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(Date userCreatetime) {
        this.userCreatetime = userCreatetime;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userPassword="
				+ userPassword + ", userNickname=" + userNickname + ", userSex=" + userSex + ", userBithday="
				+ userBithday + ", userAddress=" + userAddress + ", userImgurl=" + userImgurl + ", userCreatetime="
				+ userCreatetime + "]";
	}
    
    
}