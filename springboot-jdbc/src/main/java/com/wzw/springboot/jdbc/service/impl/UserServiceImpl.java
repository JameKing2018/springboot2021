package com.wzw.springboot.jdbc.service.impl;

import com.wzw.springboot.jdbc.domain.User;
import com.wzw.springboot.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    UserServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public int create(User user) {
        return jdbcTemplate.update("insert  into USER (NAME ,AGE) VALUES (?,?)",user.getName(),user.getAge());
    }

    @Override
    public List<User> getByName(String name) {
        List<User> users=jdbcTemplate.query("select NAME,AGE FROM USER WHERE NAME=?",((resultSet, i) -> {
            User user=new User();
            user.setName(resultSet.getString("NAME"));
            user.setAge(resultSet.getInt("AGE"));
            return user;
        }),name);
        return users;
    }

    @Override
    public int deleteName(String name) {
        return jdbcTemplate.update("delete from USER WHERE NAME =?",name);
    }

    @Override
    public int getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER",Integer.class);
    }

    @Override
    public int deleteAllUsers() {
        return jdbcTemplate.update("delete from USER ");
    }
}
