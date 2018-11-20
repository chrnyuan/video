package com.zhiyou.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.CourseMapper;
import com.zhiyou.dao.SpeakerMapper;
import com.zhiyou.dao.SubjectMapper;
import com.zhiyou.dao.VideoMapper;
import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.Video;
import com.zhiyou.pojo.VideoExample;
import com.zhiyou.pojo.VoQuery;
@Service
public class VideoServiceImpl  implements VideoService{

	@Autowired
	private VideoMapper videoMapper;
	
	@Autowired 
	private SpeakerMapper speakerMapper;
	
	@Autowired 
	private CourseMapper courseMapper;
	
	@Autowired 
	private SubjectMapper SubjectMapper;
	
	@Override
	public List<Video> selectvideoAll() {
		System.out.println("service方法");
		List<Video> list = videoMapper.selectAll();
	
		return list;
	}
	
	//添加视频信息
	@Override
	public void insertVideo(Video video) {
		
		int i = videoMapper.insert(video);
		System.out.println(i);
		
	}
	
	//跳转到修改视频信息
	@Override
	public Video selectVideoById(Integer videoId) {
		Video video = videoMapper.selectByPrimaryKey(videoId);
		return video;
	}
	
	//修改视频信息
	@Override
	public void updateVideo(Video video) {
		videoMapper.updateByPrimaryKey(video);
		
	}
	//删除视频信息
	@Override
	public void deletVideoById(Integer videoId) {
		videoMapper.deleteByPrimaryKey(videoId);
		
	}
	//批量删除信息
	@Override
	public void delteManyVideo(Integer[] videoIds) {
		for (Integer integer : videoIds) {
			int i = videoMapper.deleteByPrimaryKey(integer);
			System.out.println(i);
		}
		
	}
	//联合查询
	@Override
	public List<Video> SelectVideos(Video video) {
		System.out.println(video.getCourseId()+video.getSpeakerId());
		VideoExample example = new VideoExample();
		example.createCriteria().andCourseIdEqualTo(video.getCourseId()).andCourseIdEqualTo(video.getSpeakerId());
		 List<Video> list = videoMapper.selectByExample(example);
		 for (Video video2 : list) {
			System.out.println(video2);
		}
		return list;
	
	}
	//查询视频信息和讲师信息
	@Override
	public VoQuery selectVoQuery(Integer videoId) {
		
		Video video = videoMapper.selectByPrimaryKey(videoId);
		Speaker speaker = speakerMapper.selectByPrimaryKey(video.getSpeakerId());
		Course course = courseMapper.selectByPrimaryKey(video.getCourseId());
		Subject subject = SubjectMapper.selectByPrimaryKey(course.getSubjectId());
		List<Video> list = videoMapper.selectVideoBySpeakerId(video.getSpeakerId());
		
		return new VoQuery(video,speaker,course,subject,list);
		
	}
	
	//根据视频标题搜索视频
	@Override
	public Video selectVideoByVideoTitle(String videoTitle) {
		return videoMapper.selectVideoByTitle(videoTitle);
	
	}

}
