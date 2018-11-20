package com.zhiyou.Service;

import java.util.List;

import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Subject;

public interface CourseService {
	
	List<Course> selectCourse();
	//得到Subject信息
	List<Subject> getSubject();
	void insertCourse(Course course);
	Course showUpdateCourse(Integer courseId);
	void courseUpdate(Course course);
	void courseDelete(Integer courseId);
	void courseDeleteAll(Integer[] courseIds);
	//course一对多查询
	List<Course> selectCourseVideoAll();
}
