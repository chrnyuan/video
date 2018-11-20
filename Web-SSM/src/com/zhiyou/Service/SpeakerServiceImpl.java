package com.zhiyou.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.SpeakerMapper;
import com.zhiyou.pojo.Speaker;

@Service
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	private SpeakerMapper speakerMapper;
	
	//查询主讲人所有信息
	@Override
	public List<Speaker> selectAllSpeaker() {
		return speakerMapper.selectByExample(null);
		
	}
	//展示要修改的主讲人信息
	@Override
	public Speaker selectSpeaker(Integer speakerId) {
		
		return speakerMapper.selectByPrimaryKey(speakerId);
		
	}
	//修改主讲人信息     
	@Override
	public void updateSpeaker(Speaker speaker) {
		int i = speakerMapper.updateByPrimaryKey(speaker);
		System.out.println(i);
			
	}
	
	//添加主讲人信息
	@Override
	public void insertSpeaker(Speaker speaker) {
		speakerMapper.insert(speaker);
		
	}
	
	//删除主讲人信息
	@Override
	public Integer deleteSpeaker(Integer speakerId) {
		return speakerMapper.deleteByPrimaryKey(speakerId);
		
	}
	
	//批量删除主讲人信息
	@Override
	public Integer deleteManySpeaker(Integer[] speakerIds) {
		Integer i=0;
		for (Integer integer : speakerIds) {
			 i = speakerMapper.deleteByPrimaryKey(integer);
		}
		return i;
	}
	

	

}
