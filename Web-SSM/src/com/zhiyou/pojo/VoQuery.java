package com.zhiyou.pojo;

import java.util.List;

public class VoQuery {

	private Video video;
	private Speaker speaker;
	private Course course;
	private Subject subject;
	private List<Video> videos;
	
	
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "VoQuery [video=" + video + ", speaker=" + speaker + ", course=" + course + ", subject=" + subject
				+ ", videos=" + videos + "]";
	}
	public VoQuery(Video video, Speaker speaker, Course course, Subject subject, List<Video> videos) {
		super();
		this.video = video;
		this.speaker = speaker;
		this.course = course;
		this.subject = subject;
		this.videos = videos;
	}
	

	
	

	
	
	
}
