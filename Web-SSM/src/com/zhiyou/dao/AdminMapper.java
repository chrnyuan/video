package com.zhiyou.dao;

import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    //–£—È’À∫≈√‹¬Î
    Admin selectAdminByName(Admin admin);
    
    //◊¢≤·’À∫≈
    int insertAdmin(Admin admin);
   //–£—È’À∫≈ «∑Ò¥Ê‘⁄
    Admin selectAdminByadminName(String adminName);
    
}