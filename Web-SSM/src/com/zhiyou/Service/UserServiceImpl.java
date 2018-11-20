package com.zhiyou.Service;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserMapper;
import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.User;
import com.zhiyou.pojo.UserExample;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	//验证用户账号是否存在
	@Override
	public boolean userverifty(Integer id) {
		User user = userMapper.selectByPrimaryKey(id);
		
		if (user==null) {
			return false;
		}else{
			return true;
		}
		
	}
	
	//校验密码是否存在

	@Override
	public boolean veriftypassword(String password) {
		 User user = userMapper.selectUserPassword(password);
		 System.out.println(user);
		 if (user==null) {
				return false;
			}else{
				return true;
			}
	}

	
	//用户登录校验
	@Override
	public boolean userLogin(User user) {
		
//		UserExample example = new UserExample();
//		example.createCriteria().andUserIdEqualTo(user.getUserId()).andUserPasswordEqualTo(user.getUserPassword());
//		userMapper.selectByExample(example);
		User user2 = userMapper.selectUserByuserId(user);
		String password = user.getUserPassword();
		if (user2 != null) {
			if (password.equals(user2.getUserPassword())) {
				return true;
			}
		}
		return false;
	}
	
	//用户注册
	@Override
	public boolean userRegister(User user) {
		int i = userMapper.insert(user);
		if (i != 0) {
			return true;
		}
		return false;
	}
	
	//跳转更改用户资料
	@Override
	public User UpdateUserDateById(Integer userId) {
		
		User user = userMapper.selectByPrimaryKey(userId);
		System.out.println(user);
		return user;
	}
	
	//修改用户资料
	@Override
	public void UpdateUserDate(User user) {
		userMapper.UpdateUserDate(user);
		
		
	}
	//跳转到修改头像页面   
	@Override
	public User selectUserPicByUserId(Integer userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}
	//修改头像
	@Override
	public User UpdateUserPic(User user) {
		System.out.println(user.getUserImgurl()+user.getUserId());
		userMapper.updateUserPicById(user);
		User user2 = userMapper.selectByPrimaryKey(user.getUserId());
		System.out.println(user2);
		return user2;
	}
	//修改密码
	@Override
	public void UpdateUserPassword(User user) {
		System.out.println(user);
		userMapper.updateUserPassword(user);
		
	}
	
	//
	@Override
	public User selectUserById(User user) {
		return userMapper.selectUserByuserId(user);
		
	}

	

	
	
	
}
