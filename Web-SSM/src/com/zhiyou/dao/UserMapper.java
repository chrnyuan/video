package com.zhiyou.dao;

import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.User;
import com.zhiyou.pojo.UserExample;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //获取到用户的个人信息
    User selectUserId(Integer UserId);
    
    //修改用户资料
    void UpdateUserDate(User user);
    
    //校验用户账号
   User selectUserByuserId(User user);
   
   //修改密码
   void updateUserPassword(User user);
   
   //修改User头像
   void updateUserPicById(User user);
   
   
   //验证密码是否存在
   User selectUserPassword(String password);
   
}