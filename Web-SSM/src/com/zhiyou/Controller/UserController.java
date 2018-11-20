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
	private final int FILE_MAXSIZE = 10000000;// 单个文件的最大的内存10M
	
	@Autowired
	private UserService userService;
	
	//用户注册界面          
	@RequestMapping(value="userRegister.action")
	public String userRegister(){
			
		return "userRegister";
			
	}
	
	//跳转用户登录界面              
	@RequestMapping(value="userLogin.action")
	public String findUserLogin(){
		
		return "userLogin";
		
	}
	//验证用户账号是存在        	@ResponseBody用于ajax验证跳过视图解析器
	@ResponseBody
	@RequestMapping(value="verifty.action")
	public String veriftyUserLogin(Integer id){
		System.out.println("进入verifty");
		System.out.println(id);
		boolean b = userService.userverifty(id);
		
		if (b) {
			return "1";
		}else{
			return "2";
		}
		
		
	}
	
	
	//验证密码是否存在  
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
	
	//校验用户是否被注册    
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
	
	
	//用户注册            
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
	
	
	//校验用户账号密码
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
			model.addAttribute("error", "账号或密码输入错误");
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
		model.addAttribute("error", "账号或密码输入错误");
		return "forward:/WEB-INF/jsp/userLogin.jsp";
	}
	
	//个人中心页面
	@RequestMapping(value="userConter.action")
	public String showUserConter(Model model ,HttpSession session){
		Integer id= (Integer) session.getAttribute("username");
		User user = userService.UpdateUserDateById(id);
		model.addAttribute("user", user);
		return "userConter";
		
	}
	
	// 跳转到修改用户资料    
	@RequestMapping(value="user.UpdateDate.action")
	public String updateUserDate(Integer userId,Model model){
		User user = userService.UpdateUserDateById(userId);
		model.addAttribute("user", user);
		return "userChangeTheDate";
	}
	
	//修改用户资料  
	@RequestMapping(value="user.updateDate.action",method=RequestMethod.POST)
	public String updateUserDateById(User user){
		System.out.println(user);
		userService.UpdateUserDate(user);
		return "Succes";
		
	}
	
	// 跳转到修改用户密码  
	@RequestMapping(value="user.UpdatePassword.action")
	public String updateUserPassword(Integer userId,Model model){
		System.out.println(userId);
		User user = userService.UpdateUserDateById(userId);
		model.addAttribute("user", user);
		return "userChangePassword";
	}
	
	//更改用户密码   
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
			model.addAttribute("msg", "原密码错误");
			return "userChangePassword";	
		}else if (c==false) {
			model.addAttribute("ms", "两次密码输入不一致，请重新输入");
			return "userChangePassword";
		}else {
			user.setUserPassword(newPassword);
			userService.UpdateUserPassword(user);
		}
		return "Succes";
	}
	
	//跳转到修改头像页面   
	@RequestMapping(value="user.Updatehead.action")
	public String updateUserPic(Integer userId,Model model){
		User user = userService.selectUserPicByUserId(userId);
		model.addAttribute("user", user);
		return "userChangeThePicture";
	}
	
	//修改头像
	@RequestMapping(value="user.UploodPic.action",method=RequestMethod.POST)
	public String updateUserPic(MultipartFile file,HttpServletRequest request,HttpServletResponse response,User user,Model model){
		String oldfileName = file.getOriginalFilename();
		
		//获得旧文件后缀名
		String oldSuffix = FilenameUtils.getExtension(oldfileName);
		System.out.println(oldSuffix);
		Integer userid = (Integer) request.getSession().getAttribute("username");
		user.setUserId(userid);
//		System.out.println("userId"+user.getUserId());
		
		
		if (file.getSize()>FILE_MAXSIZE) {//上传文件大小超出允许的最大内存
			 //保存错误信息
            model.addAttribute("error", "单个文件大小不得超过10M！");
            //返回错误页面显示信息
            return "userChangeThePicture";
		}else if(oldSuffix.equalsIgnoreCase("jpg")
                || oldSuffix.equalsIgnoreCase("png")
                || oldSuffix.equalsIgnoreCase("pneg")
                || oldSuffix.equalsIgnoreCase("jpeg")
                || oldSuffix.equalsIgnoreCase("gif")){
			//获得Tomcat的上下文的路径
			String path = request.getSession().getServletContext().getRealPath("/")+"123/"+file.getOriginalFilename();
			System.out.println(path);
			try {
				file.transferTo(new File(path));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//把图片的相对路径保存到数据库中
			String sqlPath = "http://localhost:8080/Web-SSM/123/"+file.getOriginalFilename();
			user.setUserImgurl(sqlPath);
			User user2 = userService.UpdateUserPic(user);
			System.out.println("user2"+user2);
			model.addAttribute("user", user2);
			
			
			
		}else{
			 model.addAttribute("error", "上传文件格式不正确！");
		}

		return "userChangeThePicture";
	}
	
	//注销   
		@RequestMapping(value="outUserlogin.action")
		public String outUserLogin(HttpSession session){
			session.invalidate();
			return "forward:/welcmoe.jsp";
			
		}
		


}
