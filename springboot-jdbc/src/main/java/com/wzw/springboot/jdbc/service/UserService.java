package com.wzw.springboot.jdbc.service;

import com.wzw.springboot.jdbc.domain.User;

import java.util.List;

public interface UserService {
    int create(User user);
    List<User> getByName(String name);
    int deleteName(String name);
    int getAllUsers();
    int deleteAllUsers();
}
