package com.drive.GoogleDriveProject.Messages.Mapper;

import com.drive.GoogleDriveProject.Messages.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE username=#{user}")
    User getUser(String user);

    @Insert("INSERT INTO USERS (userName,salt,password,firstName,lastName) VALUES(#{username},{#salt},{#password},#{firstName},#{lastName})")
    @Options(useGeneratedKeys = true,keyProperty = "userId")
    int insert(User user);
}
