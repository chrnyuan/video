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
	//courseһ�Զ��ѯ
	@Override
	public List<Course> selectCourseVideoAll() {
			
		List<Course> list = courseMapper.selectAll();
		
			
		return list;
	}
		
	//�õ�Subject��Ϣ
	@Override
	public List<Subject> getSubject() {
		return subjectMapper.selectByExample(null);
		
	}
	//���
	@Override
	public void insertCourse(Course course) {
		
		int i = courseMapper.insert(course);
		System.out.println(i);
		
	}
	
	//չʾ�޸�
	@Override
	public Course showUpdateCourse(Integer courseId) {
		Course course = courseMapper.selectByPrimaryKey(courseId);
		return course;
	}
	//�޸�
	@Override
	public void courseUpdate(Course course) {
		
		int i = courseMapper.updateByPrimaryKey(course);
		System.out.println(i);
		
	}
	//ɾ����Ϣ
	@Override
	public void courseDelete(Integer courseId) {
		int i = courseMapper.deleteByPrimaryKey(courseId);
		System.out.println(i);
		
	}
	//����ɾ��
	@Override
	public void courseDeleteAll(Integer[] courseIds) {
		for (Integer integer : courseIds) {
			int i = courseMapper.deleteByPrimaryKey(integer);
			System.out.println(i);
		}
		
	}
	
	
	
	
	

}
