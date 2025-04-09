package org.example.springbootproject01.service.impl;

import org.example.springbootproject01.Pojo.User_db;
import org.example.springbootproject01.mapper.UserMapper;
import org.example.springbootproject01.service.User_dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User_dbServiceA implements User_dbService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User_db> listUser_db() {
        return userMapper.list();
    }
    @Override
    public void deleteUser_db(Integer id){
        userMapper.delete(id);
    };
    @Override
    public void insertUser_db(User_db user_db){
        userMapper.insert(user_db);
    };
}
