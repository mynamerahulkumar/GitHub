package com.udacity.jwdnd.spring_security_basics.service;

import com.udacity.jwdnd.spring_security_basics.mapper.UserMapper;
import com.udacity.jwdnd.spring_security_basics.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final HashService hashService;


    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }
    public boolean isUserNameAvailable(String username){
        return userMapper.getUser(username)==null;
    }
    public int createUser(User user){
        SecureRandom secureRandom=new SecureRandom();
        byte[] salt=new byte[16];
        secureRandom.nextBytes(salt);
        String encodedSalt= Base64.getEncoder().encodeToString(salt);
        String hashedPassword=hashService.getHashValue(user.getPassword(),encodedSalt);
        return userMapper.insert( new User(null,user.getUsername(),encodedSalt,hashedPassword,user.getFirstName(),user.getLastName()));
    }
    public User getUser(String username){
        return userMapper.getUser(username);
    }
}
