package com.blog.app.service;

import com.blog.app.dto.UserDto;

import java.util.List;

public interface UserService{

    //add user
    UserDto addUser(UserDto userDto);

    //update user
    UserDto updateUser(UserDto userDto, int userId);

    //get single user
    UserDto getUser(int userId);

    //get all user
    List<UserDto> getAllUser();

    //delete user
    void deleteUser(int userId);

}
