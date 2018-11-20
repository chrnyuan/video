package com.zhiyou.Service;

import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.User;


public interface UserService {

	boolean userLogin(User user);
	boolean userRegister(User user);
	
	//��֤�û��˺��Ƿ����
	boolean userverifty(Integer id);
	
	//У�������Ƿ����
	boolean veriftypassword(String password);
		
	
	User selectUserById(User user);
	
	User UpdateUserDateById(Integer userId);
	
	//�޸��û�
	
	void UpdateUserDate(User user);
	
	//�޸�����
	
	void UpdateUserPassword(User user);
	
	
	User selectUserPicByUserId(Integer userId);
	User UpdateUserPic(User user);
}
