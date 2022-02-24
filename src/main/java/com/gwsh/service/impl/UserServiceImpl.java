package com.gwsh.service.impl;

import com.gwsh.entities.User;
import com.gwsh.mapper.UserMapper;
import com.gwsh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    /// IOC 注入Mapper
    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "userCache", key = "'user.getAllUsers'")
    @Override
    public List<User> getAllUsers() {
        return this.userMapper.getAllUsers();
    }
    @CacheEvict(value = "userCache", key = "'user.getAllUsers'")
    @Override
    public void delete(Integer id) {
        System.out.println("删除id为" + id + "的用户");
        this.userMapper.delete(id);
    }
}
