package com.example.demo.service;


import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    User getUserByID(int id);

    int insertUser(User user);

    int deleteUserByID(int id);

    int updateUser(User user);

    List<User> getAllUsers();

}
