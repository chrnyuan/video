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
	
	//��ѯ������������Ϣ
	@Override
	public List<Speaker> selectAllSpeaker() {
		return speakerMapper.selectByExample(null);
		
	}
	//չʾҪ�޸ĵ���������Ϣ
	@Override
	public Speaker selectSpeaker(Integer speakerId) {
		
		return speakerMapper.selectByPrimaryKey(speakerId);
		
	}
	//�޸���������Ϣ     
	@Override
	public void updateSpeaker(Speaker speaker) {
		int i = speakerMapper.updateByPrimaryKey(speaker);
		System.out.println(i);
			
	}
	
	//�����������Ϣ
	@Override
	public void insertSpeaker(Speaker speaker) {
		speakerMapper.insert(speaker);
		
	}
	
	//ɾ����������Ϣ
	@Override
	public Integer deleteSpeaker(Integer speakerId) {
		return speakerMapper.deleteByPrimaryKey(speakerId);
		
	}
	
	//����ɾ����������Ϣ
	@Override
	public Integer deleteManySpeaker(Integer[] speakerIds) {
		Integer i=0;
		for (Integer integer : speakerIds) {
			 i = speakerMapper.deleteByPrimaryKey(integer);
		}
		return i;
	}
	

	

}
