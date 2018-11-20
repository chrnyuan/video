package com.zhiyou.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhiyou.dao.SubjectMapper;
import com.zhiyou.pojo.Subject;
@Service
public class SubjectServiceImpl implements SubjectService {

	private SubjectMapper subjectMapper;
	
	@Override
	public List<Subject> selectSubject() {
		return subjectMapper.selectByExample(null);
	
	}

}
