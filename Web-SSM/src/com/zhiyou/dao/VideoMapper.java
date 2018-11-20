package com.zhiyou.dao;

import com.zhiyou.pojo.Video;
import com.zhiyou.pojo.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer videoId);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer videoId);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
    
    //1对一查询
    List<Video> selectAll();
    
    Video selectVideoAndSpeakerById(Integer videoId);
    
    
    //通过SpeakerId来查询
    List<Video> selectVideoBySpeakerId(Integer speakerId);
//    List<Video> SelectVideoS();
    Video selectVideoByTitle(String videoTitle);
    
}