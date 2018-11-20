package com.zhiyou.Service;

import com.zhiyou.pojo.Admin;

public interface AdminService {
	boolean  checkoutAdmin(Admin admin);
	boolean adminRegister(Admin admin);
	int veriftyName(String adminName);
	
	
}
