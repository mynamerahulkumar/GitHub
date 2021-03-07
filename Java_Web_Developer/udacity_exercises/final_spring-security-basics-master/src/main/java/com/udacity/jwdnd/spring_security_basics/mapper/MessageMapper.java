package com.udacity.jwdnd.spring_security_basics.mapper;

import com.udacity.jwdnd.spring_security_basics.model.MessageForm;
import com.udacity.jwdnd.spring_security_basics.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE username=#{username}")
    MessageForm getMessage(String username);


    @Insert("INSERT INTO MESSAGE (username,messagetext) VALUES(#{username},#{messagetext})")
    @Options(useGeneratedKeys = true,keyProperty = "messageId")
    int insert(MessageForm messageForm);

}
