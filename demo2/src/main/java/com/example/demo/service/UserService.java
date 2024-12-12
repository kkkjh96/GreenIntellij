package com.example.demo.service;

import com.example.demo.dto.UserDto;


public interface UserService {

     void regist(UserDto user);

     UserDto getUser(UserDto user);

}
