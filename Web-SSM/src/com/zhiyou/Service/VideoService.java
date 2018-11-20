package com.zhiyou.Service;

import java.util.List;

import com.zhiyou.pojo.Video;
import com.zhiyou.pojo.VoQuery;

public interface VideoService {

	List<Video> selectvideoAll();
	
	void insertVideo(Video video);
	
	
	Video selectVideoById(Integer videoId);
	void updateVideo(Video video);
	
	void deletVideoById(Integer videoId);
	
	void delteManyVideo(Integer[] videoIds);
	
	List<Video> SelectVideos(Video video);
	
	
	VoQuery selectVoQuery(Integer videoId);
	
	Video selectVideoByVideoTitle(String videoTitle);
}