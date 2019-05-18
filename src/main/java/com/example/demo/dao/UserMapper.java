package com.example.demo.dao;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    User getUserByID(int id);

    int insertUser(User user);

    int deleteUserByID(int id);

    int updateUser(User user);

    List<User> getAllUsers();


}
