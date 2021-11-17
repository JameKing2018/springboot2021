package com.wzw.springboot.restful.web;

import com.wzw.springboot.restful.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/users")
public class UserController {
    static Map<Long, User> users= Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation("获取用户列表")
    @GetMapping("/")
    public List<User> getUserList(){
        return new ArrayList<User>(users.values());
    }
    @ApiOperation("创建用户")
    @PostMapping("/")
    public String postUser(@Validated @RequestBody User user){
        users.put(user.getId(),user);
        return "SUCCESS";
    }
    @ApiOperation("获取用户详情")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }
    @ApiOperation("更新用户信息")
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id,@RequestBody User user){
        User u=users.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        users.put(id,u);
        return "SUCCESS";
    }
    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "SUCCESS";
    }
}
