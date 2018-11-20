package com.zhiyou.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.Service.CourseService;
import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Subject;


@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="lession.action")
	public String selectListCourse(HttpServletRequest request ,HttpServletResponse response ,Model model){
		//startPage�����ҳ��ʼ��
		int page=request.getParameter("page")==null?1:Integer.valueOf(request.getParameter("page"));
		PageHelper.startPage(page,4);
		List<Course> list = courseService.selectCourse();
		
        //ʹ��PageInfo��װ��ѯ�����ֻ��Ҫ��pageInfo����ҳ��Ϳ���
		PageInfo<Course> p = new PageInfo<>(list);
	
		model.addAttribute("page", p);
		model.addAttribute("CourseList",list);
		return "lession";
		
	}
	//��ת���ҳ��
	@RequestMapping(value="courseInsert.action")
	public String courseInsert(Model model){
		List<Subject> list = courseService.getSubject();
		
		model.addAttribute("subject", list);
		return "courseInsert";
		
	}
	
	//չʾvideo��Ϣ
	@RequestMapping(value="A.user.action")
	public String showVideo(Model model){
		List<Course> list = courseService.selectCourseVideoAll();
		model.addAttribute("courseVideoList", list);
		return "WebFrontEnd";
		
	}
	
	//�������
	@RequestMapping(value="courseInsertA.action",method=RequestMethod.POST)
	public String courseInsert(Course course){
		courseService.insertCourse(course);
		return "forward:/lession.action";
	}
	
	//��ת���޸�ҳ��
	@RequestMapping(value="course.Update.action")
	public String courseUpdate(Integer courseId,Model model){
		Course course = courseService.showUpdateCourse(courseId);
		List<Subject> list = courseService.getSubject();
		for (Subject subject : list) {
			System.out.println(subject);
		}
		model.addAttribute("courseS", course);
		System.out.println(course);
		model.addAttribute("subjectList",list);
		return "courseUpdate";
	}	
	//�޸�����
	@RequestMapping(value="course.Update.action",method=RequestMethod.POST)
	public String courseUpdate(Course course){
		courseService.courseUpdate(course);
		System.out.println(course.getCourseId()+course.getCourseTitle()+course.getCourseDesc());
		return "forward:/lession.action";
	}
	//ɾ������
	@RequestMapping(value="course.Delete.action")
	public String courseDelte(Integer courseId){
		courseService.courseDelete(courseId);
		return "forward:/lession.action";
	}
	
	//����ɾ������
	@RequestMapping(value="courseDeleteAll.action",method=RequestMethod.POST)
	public String courseDeleteAll(Integer[] courseIds){
		courseService.courseDeleteAll(courseIds);
		return "forward:/lession.action";
		
	}
	
	
}
