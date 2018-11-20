package com.zhiyou.Service;

import java.util.List;

import com.zhiyou.pojo.Speaker;

public interface SpeakerService {

	List<Speaker> selectAllSpeaker();
	Speaker selectSpeaker(Integer speakerId);
	
	void insertSpeaker(Speaker speaker);
	
	void updateSpeaker(Speaker speaker);
	
	Integer deleteSpeaker(Integer speakerId);
	
	Integer deleteManySpeaker(Integer[] speakerIds);
	
}
