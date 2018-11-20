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
    
    //��ȡ���û��ĸ�����Ϣ
    User selectUserId(Integer UserId);
    
    //�޸��û�����
    void UpdateUserDate(User user);
    
    //У���û��˺�
   User selectUserByuserId(User user);
   
   //�޸�����
   void updateUserPassword(User user);
   
   //�޸�Userͷ��
   void updateUserPicById(User user);
   
   
   //��֤�����Ƿ����
   User selectUserPassword(String password);
   
}