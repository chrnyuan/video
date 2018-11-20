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
		System.out.println("service����");
		List<Video> list = videoMapper.selectAll();
	
		return list;
	}
	
	//�����Ƶ��Ϣ
	@Override
	public void insertVideo(Video video) {
		
		int i = videoMapper.insert(video);
		System.out.println(i);
		
	}
	
	//��ת���޸���Ƶ��Ϣ
	@Override
	public Video selectVideoById(Integer videoId) {
		Video video = videoMapper.selectByPrimaryKey(videoId);
		return video;
	}
	
	//�޸���Ƶ��Ϣ
	@Override
	public void updateVideo(Video video) {
		videoMapper.updateByPrimaryKey(video);
		
	}
	//ɾ����Ƶ��Ϣ
	@Override
	public void deletVideoById(Integer videoId) {
		videoMapper.deleteByPrimaryKey(videoId);
		
	}
	//����ɾ����Ϣ
	@Override
	public void delteManyVideo(Integer[] videoIds) {
		for (Integer integer : videoIds) {
			int i = videoMapper.deleteByPrimaryKey(integer);
			System.out.println(i);
		}
		
	}
	//���ϲ�ѯ
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
	//��ѯ��Ƶ��Ϣ�ͽ�ʦ��Ϣ
	@Override
	public VoQuery selectVoQuery(Integer videoId) {
		
		Video video = videoMapper.selectByPrimaryKey(videoId);
		Speaker speaker = speakerMapper.selectByPrimaryKey(video.getSpeakerId());
		Course course = courseMapper.selectByPrimaryKey(video.getCourseId());
		Subject subject = SubjectMapper.selectByPrimaryKey(course.getSubjectId());
		List<Video> list = videoMapper.selectVideoBySpeakerId(video.getSpeakerId());
		
		return new VoQuery(video,speaker,course,subject,list);
		
	}
	
	//������Ƶ����������Ƶ
	@Override
	public Video selectVideoByVideoTitle(String videoTitle) {
		return videoMapper.selectVideoByTitle(videoTitle);
	
	}

}
