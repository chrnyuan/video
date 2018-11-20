package com.zhiyou.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.AdminMapper;
import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.AdminExample;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminMapper;
	
	public boolean  checkoutAdmin(Admin admin){
		String password = admin.getAdminPassword();
		System.out.println(password);
//		AdminExample example = new AdminExample();
//		example.createCriteria().andAdminPasswordEqualTo(admin.getAdminPassword()).andAdminNameEqualTo(admin.getAdminName());
//		adminMapper.selectByExample(example);
		Admin admin2 = adminMapper.selectAdminByName(admin);
		if (admin2 != null ) {
			if (password.equals(admin2.getAdminPassword())) {
				return true;
			}
			
		}
		
		return false;
		
	}
	//管理员注册
	@Override
	public boolean adminRegister(Admin admin) {
		 int i = adminMapper.insertAdmin(admin);
		 System.out.println(i);
		if (i!= 0) {
			return true;
		}
		return false;
	}
	
	//验证账号是否存在
	@Override
	public int veriftyName(String adminName) {
		Admin admin = adminMapper.selectAdminByadminName(adminName);
		if (admin==null) {
			return 0;
		}else{
			return 1;
		}
		
	}

	
}
