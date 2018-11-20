package com.zhiyou.Service;

import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.User;


public interface UserService {

	boolean userLogin(User user);
	boolean userRegister(User user);
	
	//验证用户账号是否存在
	boolean userverifty(Integer id);
	
	//校验密码是否存在
	boolean veriftypassword(String password);
		
	
	User selectUserById(User user);
	
	User UpdateUserDateById(Integer userId);
	
	//修改用户
	
	void UpdateUserDate(User user);
	
	//修改密码
	
	void UpdateUserPassword(User user);
	
	
	User selectUserPicByUserId(Integer userId);
	User UpdateUserPic(User user);
}
