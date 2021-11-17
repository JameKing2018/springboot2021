package com.wzw.springboot.jdbc.web;


import com.sun.istack.internal.NotNull;
import com.wzw.springboot.jdbc.domain.User;
import com.wzw.springboot.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public int createUser(@NotNull @RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable @NotNull String name){
        return userService.getByName(name);
    }
    @DeleteMapping("/{name}")
    public int deleteName(@PathVariable @NotNull String name){
        return userService.deleteName(name);
    }

    @GetMapping("/allUsers")
    public int getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/allUsers")
    public int deleteAllUsers(){
        return userService.deleteAllUsers();
    }

}
