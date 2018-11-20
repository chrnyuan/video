package com.zhiyou.Service;

import java.util.List;

import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Subject;

public interface CourseService {
	
	List<Course> selectCourse();
	//�õ�Subject��Ϣ
	List<Subject> getSubject();
	void insertCourse(Course course);
	Course showUpdateCourse(Integer courseId);
	void courseUpdate(Course course);
	void courseDelete(Integer courseId);
	void courseDeleteAll(Integer[] courseIds);
	//courseһ�Զ��ѯ
	List<Course> selectCourseVideoAll();
}
