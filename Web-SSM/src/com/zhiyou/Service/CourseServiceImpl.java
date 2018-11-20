package com.zhiyou.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.CourseMapper;
import com.zhiyou.dao.SubjectMapper;
import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Subject;
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public List<Course> selectCourse() {
		List<Course> list = courseMapper.selectByExample(null);
		
		return list;
	}
	//course一对多查询
	@Override
	public List<Course> selectCourseVideoAll() {
			
		List<Course> list = courseMapper.selectAll();
		
			
		return list;
	}
		
	//得到Subject信息
	@Override
	public List<Subject> getSubject() {
		return subjectMapper.selectByExample(null);
		
	}
	//添加
	@Override
	public void insertCourse(Course course) {
		
		int i = courseMapper.insert(course);
		System.out.println(i);
		
	}
	
	//展示修改
	@Override
	public Course showUpdateCourse(Integer courseId) {
		Course course = courseMapper.selectByPrimaryKey(courseId);
		return course;
	}
	//修改
	@Override
	public void courseUpdate(Course course) {
		
		int i = courseMapper.updateByPrimaryKey(course);
		System.out.println(i);
		
	}
	//删除信息
	@Override
	public void courseDelete(Integer courseId) {
		int i = courseMapper.deleteByPrimaryKey(courseId);
		System.out.println(i);
		
	}
	//批量删除
	@Override
	public void courseDeleteAll(Integer[] courseIds) {
		for (Integer integer : courseIds) {
			int i = courseMapper.deleteByPrimaryKey(integer);
			System.out.println(i);
		}
		
	}
	
	
	
	
	

}
