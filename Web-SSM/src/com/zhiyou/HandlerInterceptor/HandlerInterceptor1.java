package com.zhiyou.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 定义一个拦截器类
 * */
public class HandlerInterceptor1  implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
	
		String adminName = (String) request.getSession().getAttribute("adminName");
		
		Integer username =  (Integer) request.getSession().getAttribute("username");
	
		if (uri.contains("speaker") || uri.contains("course") || uri.contains("video")|| uri.contains("lession")) {
			if (adminName==null||adminName=="") {
				request.getRequestDispatcher("adminLogin.action").forward(request, response);
				return false;
				
			}
		}
		if(uri.contains("user") ){
			if (username==null) {
				request.getRequestDispatcher("userLogin.action").forward(request, response);
				
				return false;
				
			}
		}
		return true;
		
	}

}
