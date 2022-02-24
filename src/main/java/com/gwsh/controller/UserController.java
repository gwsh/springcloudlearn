package com.gwsh.controller;

import com.gwsh.entities.User;
import com.gwsh.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取用户列表
     *
     * @return 返回用户列表对象
     */
    @GetMapping("/getAllUserList")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    /**
     * 根据用户id删除用户
     *
     * @param id 用户id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        this.userService.delete(id);
    }

}
