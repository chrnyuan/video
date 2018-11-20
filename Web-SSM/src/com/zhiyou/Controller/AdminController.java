package com.zhiyou.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.Service.AdminService;
import com.zhiyou.pojo.Admin;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	//��תadminLogin.jspҳ��
	@RequestMapping(value="adminLogin.action")
	public String showhtml(){
		
		return "adminLogin";
		
	}
	//��֤�˺��Ƿ����  
	@ResponseBody
	@RequestMapping(value="Verifty.action",method=RequestMethod.POST)
	public String veriftyName(String id){
		System.out.println(id);
		int i = adminService.veriftyName(id);
		if (i==0) {
			System.out.println(i);
			return "0";
		}else{
			return "1";
		}
		
	}
	//��֤�˺��Ƿ��ѱ�ע��     
	@ResponseBody
	@RequestMapping(value="veriftyAdminName.action")
	public String veriftyAdminName(String id){
		System.out.println(id);
		int i = adminService.veriftyName(id);
		if (i==0) {
			System.out.println(i);
			return "0";
		}else{
			return "1";
		}
		
		
	}
	
	
	//��֤�˺�����
	@RequestMapping(value="adminLogin.action",method=RequestMethod.POST)
	public String checkoutAdmin(Admin admin ,HttpSession session,Model model){
		System.out.println(admin.getAdminName()+admin.getAdminPassword());
		System.out.println(admin);
		boolean checkoutAdmin = adminService.checkoutAdmin(admin);
		System.out.println(checkoutAdmin);
		if (checkoutAdmin) {
			session.setAttribute("adminName", admin.getAdminName());
			return "redirect:/lession.action";
		}
		model.addAttribute("error", "�˺Ż������������");
		return "forward:/WEB-INF/jsp/adminLogin.jsp";
	}
	//����Աע�� ҳ��     
	@RequestMapping(value="adminRegister.action")
	public String adminRegister(){
		
		return "adminRegister";
		
	}
	//����Աע��
	@RequestMapping(value="adminRegister.action",method=RequestMethod.POST)
	public String adminRegister(Admin admin ,HttpSession session){
		boolean b = adminService.adminRegister(admin);
		if (b) {
			session.setAttribute("adminName", admin.getAdminName());
			return "redirect:/lession.action";
		}
		return "error";
		
	}
	//ע������         
	@RequestMapping(value="outAdminlogin.action")
	public String outAdminLogin(HttpSession session){
		session.invalidate();
		return "forward:/welcmoe.jsp";	
	}
}
