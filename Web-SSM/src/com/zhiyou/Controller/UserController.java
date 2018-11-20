package com.zhiyou.Controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.ContentTypeResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.Service.UserService;
import com.zhiyou.pojo.User;


@Controller
public class UserController {
	private final int FILE_MAXSIZE = 10000000;// �����ļ��������ڴ�10M
	
	@Autowired
	private UserService userService;
	
	//�û�ע�����          
	@RequestMapping(value="userRegister.action")
	public String userRegister(){
			
		return "userRegister";
			
	}
	
	//��ת�û���¼����              
	@RequestMapping(value="userLogin.action")
	public String findUserLogin(){
		
		return "userLogin";
		
	}
	//��֤�û��˺��Ǵ���        	@ResponseBody����ajax��֤������ͼ������
	@ResponseBody
	@RequestMapping(value="verifty.action")
	public String veriftyUserLogin(Integer id){
		System.out.println("����verifty");
		System.out.println(id);
		boolean b = userService.userverifty(id);
		
		if (b) {
			return "1";
		}else{
			return "2";
		}
		
		
	}
	
	
	//��֤�����Ƿ����  
	@ResponseBody
	@RequestMapping(value="userPassword.action")
	public String veriftypassword(String password){
		boolean b = userService.veriftypassword(password);
		if (b) {
			return "1";
		}else{
			return "2";
		}
			
	}
	
	//У���û��Ƿ�ע��    
	@ResponseBody
	@RequestMapping(value="veriftyUserId.action")
	public String veriftyUserId(Integer id){
		boolean b = userService.userverifty(id);
		if (b) {
			return "1";
		}else{
			return "2";
		}
		
		
	}
	
	
	//�û�ע��            
	@RequestMapping(value="userRegister.action",method=RequestMethod.POST)
	public String userRegister(User user,HttpSession session,HttpServletRequest request){
		
		
		/*String algorithmName = "md5";
		
		user.setUserPassword( new SimpleHash(algorithmName, user.getUserPassword()).toString());*/

		
		boolean b = userService.userRegister(user);
		if (b) {
			session.setAttribute("username", user.getUserId());	
			return "Succes";
		}
		return "error";
		
	}
	
	
	//У���û��˺�����
	@RequestMapping(value="userLogin.action",method=RequestMethod.POST)
	public String UserLogin(User user,HttpSession session,HttpServletRequest request,Model model){
		

		/*Subject subject = SecurityUtils.getSubject();
		String id = String.valueOf(user.getUserId());
		String pws = user.getUserPassword();
		UsernamePasswordToken token = new UsernamePasswordToken(id,pws);
		
		try {
			subject.login(token);
			User user2 = userService.selectUserById(user);
			
			session.setAttribute("username",user.getUserId());
			session.setAttribute("userPassword", user.getUserPassword());
			return "forward:/welcmoe.jsp";
		} catch (Exception e) {
			model.addAttribute("error", "�˺Ż������������");
			return "forward:/WEB-INF/jsp/userLogin.jsp";
	
		}*/
		
		boolean userLogin = userService.userLogin(user);
		if (userLogin) {
			session.setAttribute("username",user.getUserId());
			session.setAttribute("userPassword", user.getUserPassword());
			User user2 = userService.selectUserById(user);
			request.setAttribute("userEmail", user2.getUserEmail());
			return "forward:/welcmoe.jsp";
		}
		model.addAttribute("error", "�˺Ż������������");
		return "forward:/WEB-INF/jsp/userLogin.jsp";
	}
	
	//��������ҳ��
	@RequestMapping(value="userConter.action")
	public String showUserConter(Model model ,HttpSession session){
		Integer id= (Integer) session.getAttribute("username");
		User user = userService.UpdateUserDateById(id);
		model.addAttribute("user", user);
		return "userConter";
		
	}
	
	// ��ת���޸��û�����    
	@RequestMapping(value="user.UpdateDate.action")
	public String updateUserDate(Integer userId,Model model){
		User user = userService.UpdateUserDateById(userId);
		model.addAttribute("user", user);
		return "userChangeTheDate";
	}
	
	//�޸��û�����  
	@RequestMapping(value="user.updateDate.action",method=RequestMethod.POST)
	public String updateUserDateById(User user){
		System.out.println(user);
		userService.UpdateUserDate(user);
		return "Succes";
		
	}
	
	// ��ת���޸��û�����  
	@RequestMapping(value="user.UpdatePassword.action")
	public String updateUserPassword(Integer userId,Model model){
		System.out.println(userId);
		User user = userService.UpdateUserDateById(userId);
		model.addAttribute("user", user);
		return "userChangePassword";
	}
	
	//�����û�����   
	@RequestMapping(value="user.updatePassword.action",method=RequestMethod.POST)
	public String updateUserPassword(HttpServletRequest request,User user ,Model model){
		
		String oldPassword = request.getParameter("oldPassword");
		
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");	
		boolean b = user.getUserPassword().equals(oldPassword);
//		System.out.println(b);
		boolean c = newPassword.equals(confirmPassword);
//		System.out.println(c);
		if (b==false) {
			model.addAttribute("msg", "ԭ�������");
			return "userChangePassword";	
		}else if (c==false) {
			model.addAttribute("ms", "�����������벻һ�£�����������");
			return "userChangePassword";
		}else {
			user.setUserPassword(newPassword);
			userService.UpdateUserPassword(user);
		}
		return "Succes";
	}
	
	//��ת���޸�ͷ��ҳ��   
	@RequestMapping(value="user.Updatehead.action")
	public String updateUserPic(Integer userId,Model model){
		User user = userService.selectUserPicByUserId(userId);
		model.addAttribute("user", user);
		return "userChangeThePicture";
	}
	
	//�޸�ͷ��
	@RequestMapping(value="user.UploodPic.action",method=RequestMethod.POST)
	public String updateUserPic(MultipartFile file,HttpServletRequest request,HttpServletResponse response,User user,Model model){
		String oldfileName = file.getOriginalFilename();
		
		//��þ��ļ���׺��
		String oldSuffix = FilenameUtils.getExtension(oldfileName);
		System.out.println(oldSuffix);
		Integer userid = (Integer) request.getSession().getAttribute("username");
		user.setUserId(userid);
//		System.out.println("userId"+user.getUserId());
		
		
		if (file.getSize()>FILE_MAXSIZE) {//�ϴ��ļ���С�������������ڴ�
			 //���������Ϣ
            model.addAttribute("error", "�����ļ���С���ó���10M��");
            //���ش���ҳ����ʾ��Ϣ
            return "userChangeThePicture";
		}else if(oldSuffix.equalsIgnoreCase("jpg")
                || oldSuffix.equalsIgnoreCase("png")
                || oldSuffix.equalsIgnoreCase("pneg")
                || oldSuffix.equalsIgnoreCase("jpeg")
                || oldSuffix.equalsIgnoreCase("gif")){
			//���Tomcat�������ĵ�·��
			String path = request.getSession().getServletContext().getRealPath("/")+"123/"+file.getOriginalFilename();
			System.out.println(path);
			try {
				file.transferTo(new File(path));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//��ͼƬ�����·�����浽���ݿ���
			String sqlPath = "http://localhost:8080/Web-SSM/123/"+file.getOriginalFilename();
			user.setUserImgurl(sqlPath);
			User user2 = userService.UpdateUserPic(user);
			System.out.println("user2"+user2);
			model.addAttribute("user", user2);
			
			
			
		}else{
			 model.addAttribute("error", "�ϴ��ļ���ʽ����ȷ��");
		}

		return "userChangeThePicture";
	}
	
	//ע��   
		@RequestMapping(value="outUserlogin.action")
		public String outUserLogin(HttpSession session){
			session.invalidate();
			return "forward:/welcmoe.jsp";
			
		}
		


}
