package com.zhiyou.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.Service.CourseService;
import com.zhiyou.Service.SpeakerService;
import com.zhiyou.Service.SubjectService;
import com.zhiyou.Service.UserService;
import com.zhiyou.Service.VideoService;
import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.User;
import com.zhiyou.pojo.Video;
import com.zhiyou.pojo.VoQuery;

@Controller
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	private  CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private SubjectService subjectService;
	
	
	//��ת����Ƶ�������
	@RequestMapping(value="videoManage.action")
	public String videoManage(Model model ,HttpServletRequest request){
		//startPage�����ҳ��ʼ��
		int page=request.getParameter("page")==null?1:Integer.valueOf(request.getParameter("page"));
		PageHelper.startPage(page,6);	
		List<Video> list = videoService.selectvideoAll();
		System.out.println(list.size());	
		List<Speaker> speakers = speakerService.selectAllSpeaker();
		List<Course> course = courseService.selectCourse();
		PageInfo<Video> pageInfo = new PageInfo<>(list);
		model.addAttribute("page", pageInfo);
		
		model.addAttribute("speakerList", speakers);
		model.addAttribute("courseList", course);	
		model.addAttribute("videoList", list);
		
		return "videoManage";
		
	}
	
	//��ת�����Ƶ��Ϣ      
	@RequestMapping(value="videoInsert.action")
	public String videoInsert(Model model){
		List<Speaker> speakers = speakerService.selectAllSpeaker();
		List<Course> course = courseService.selectCourse();	
		model.addAttribute("speakerList", speakers);
		model.addAttribute("courseList", course);
		return "voideInsert";
	}
	//�����Ƶ��Ϣ      
	@RequestMapping(value="videoInsert.action",method=RequestMethod.POST)
	public String videoInsert(Video video){
		System.out.println(video);
		videoService.insertVideo(video);
		return "forward:/videoManage.action";
	}
	
	//��ת��Ҫ�޸ĵ���Ƶҳ��    
	
	@RequestMapping(value="video.Update.action")
	public String videoSelectById(Integer videoId,Model model){
		List<Speaker> speakers = speakerService.selectAllSpeaker();
		List<Course> course = courseService.selectCourse();	
		model.addAttribute("speakerList", speakers);
		model.addAttribute("courseList", course);
		Video video = videoService.selectVideoById(videoId);
		model.addAttribute("video", video);
		return "videoUpdate";
	}
	
	//�޸���Ƶ��Ϣ          
	@RequestMapping(value="videoUpdate.action",method=RequestMethod.POST)
	public String videoUpdate(Video video){
		videoService.updateVideo(video);
		return "forward:/videoManage.action";
	}
	
	//ɾ����Ƶ��Ϣ       
	@RequestMapping(value="video.Delete.action")
	public String videoDeleteById(Integer videoId){
		videoService.deletVideoById(videoId);
		return "forward:/videoManage.action";
	}
	
	//����ɾ��       
	@RequestMapping(value="videoDeleteAll.action")
	public String videoDeletes(Integer[] videoIds){
		videoService.delteManyVideo(videoIds);
		return "forward:/videoManage.action";
	}
	
	//���ϲ�ѯ            
	@RequestMapping(value="videoSelectLike.action")
	public String videoSelectLike(Model model,Video video){
		System.out.println("video"+video);
		List<Video> videos = videoService.SelectVideos(video);
		for (Video video2 : videos) {
			System.out.println("video2="+video2);
		}
		model.addAttribute("videoList", videos);
		List<Speaker> speakers = speakerService.selectAllSpeaker();
		System.out.println(speakers);
		List<Course> course = courseService.selectCourse();	
		model.addAttribute("speakerList", speakers);
		model.addAttribute("courseList", course);
		return "forward:/videoManage.action";
		
	}
	
	
	
	//չʾ��Ƶ����
	@RequestMapping(value="usershowVideo.action")
	public String Video(Model model,Integer videoId,HttpSession session){
		VoQuery voQuery = videoService.selectVoQuery(videoId);
		Integer userId = (Integer) session.getAttribute("username");
		System.out.println(userId);
		User user = userService.UpdateUserDateById(userId);
		System.out.println(user);
		model.addAttribute("user", user);
		model.addAttribute("voQuery", voQuery);
		return "showVideo";		
	}	
	
	//������Ƶ����������Ƶ     
	
	@RequestMapping(value="userwatchTitle.action")
	public String selectvideoByvideoTiltle(String videoTitle ,Model model){
		System.out.println("23435");
		Video video = videoService.selectVideoByVideoTitle(videoTitle);
		System.out.println(video);
		model.addAttribute("video", video);
		return "videoTitle";
	}
}
