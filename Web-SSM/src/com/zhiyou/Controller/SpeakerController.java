package com.zhiyou.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.Service.SpeakerService;
import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Speaker;

@Controller
public class SpeakerController {
	
	@Autowired
	private SpeakerService speakerService;
	
	//跳转到主讲人页面  展示主讲人信息
	@RequestMapping(value="speaker.action")
	public String showSpeaker(Model model,HttpServletRequest request){
		int page=request.getParameter("page")==null?1:Integer.valueOf(request.getParameter("page"));
		PageHelper.startPage(page,2);
		List<Speaker> list = speakerService.selectAllSpeaker();
		PageInfo<Speaker> p = new PageInfo<>(list);
		System.out.println(p.getSize());
		System.out.println(p.getPages());
		model.addAttribute("page", p);
		model.addAttribute("speakersList", list);
		return "speaker";
		
	}
	//跳转到主讲人添加页面 
	@RequestMapping(value="speakerInsert.action")
	public String gotoInsertSpeaker(){
		
		return "speakerInsert";
		
	} 
	//添加主讲人信息  
	@RequestMapping(value="speakerInsert.action",method=RequestMethod.POST)
	public String insertSpeaker(Speaker speaker){
		speakerService.insertSpeaker(speaker);
		return "forward:/speaker.action";
		
	} 
	//展示要修改的主讲人信息
	@RequestMapping(value="speaker.Update.action")
	public String selectSpeaker(Integer speakerId,Model model){
		
		Speaker speaker = speakerService.selectSpeaker(speakerId);
		model.addAttribute("speaker", speaker);
		return "speakerUpdate";
		
	}
	//修改主讲人信息        
	@RequestMapping(value="speaker.Update.action",method=RequestMethod.POST)
	public String updateSpeaker(Speaker speaker){
		speakerService.updateSpeaker(speaker);
		return "forward:/speaker.action";
		
	}
	//删除主讲人信息
	@RequestMapping(value="speaker.Delete.action")
	public String deleteSpeaker(Integer speakerId){
		Integer integer = speakerService.deleteSpeaker(speakerId);
		System.out.println(integer);
		return "forward:/speaker.action";
		
	} 
	//批量删除主讲人信息
	@RequestMapping(value="speaker.ManyDelete.action",method=RequestMethod.POST)
	public String deleteManySpeaker(Integer[] speakerIds){
		
		Integer integer = speakerService.deleteManySpeaker(speakerIds);
		System.out.println(integer);
		return "forward:/speaker.action";
		
	} 
}
