package org.example.springbootproject01.service;

import org.example.springbootproject01.Pojo.User_db;

import java.util.List;

public interface User_dbService {
    public List<User_db> listUser_db();

    void deleteUser_db(Integer id);

    void insertUser_db(User_db userDb);
}
