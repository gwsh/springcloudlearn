package com.gwsh.service;

import com.gwsh.entities.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户
     *
     * @return 用户数组
     */
    List<User> getAllUsers();

    /**
     * 根据用户id删除用户
     *
     * @param id 用户id
     */
    void delete(Integer id);
}
