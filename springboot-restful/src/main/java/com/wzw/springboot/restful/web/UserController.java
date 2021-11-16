package com.wzw.springboot.restful.web;

import com.wzw.springboot.restful.domain.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    static Map<Long, User> users= Collections.synchronizedMap(new HashMap<Long, User>());
    @GetMapping("/")
    public List<User> getUserList(){
        return new ArrayList<User>(users.values());
    }
    @PostMapping("/")
    public String postUser(@RequestBody User user){
        users.put(user.getId(),user);
        return "SUCCESS";
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id,@RequestBody User user){
        User u=users.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        users.put(id,u);
        return "SUCCESS";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "SUCCESS";
    }
}
