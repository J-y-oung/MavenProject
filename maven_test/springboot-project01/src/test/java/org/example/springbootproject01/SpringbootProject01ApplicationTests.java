package org.example.springbootproject01;

import org.example.springbootproject01.Pojo.User;
import org.example.springbootproject01.Pojo.User_db;
import org.example.springbootproject01.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;

@SpringBootTest
class SpringbootProject01ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testListUser(){
        List<User_db> userList = userMapper.list();
        userList.stream().forEach(user_db ->{
            System.out.println(user_db);
        });
    }
    @Test
    public void testDelete(){
        int delete = userMapper.delete(8);
        System.out.println(delete);
    }
    @Test
    public void testInsert(){
        User_db user_db = new User_db(null,"小红",(short) 18,(short) 1,"12345678901");
        userMapper.insert(user_db);
    }
    @Test
    public void testSelect(){
        User_db user_db = userMapper.select(1);
        System.out.println(user_db);
    }
    @Test
    public void testListSelect(){
        List<User_db> userList = userMapper.listSelect("小",(short)18,(short)39);
        userList.stream().forEach(user_db ->{
            System.out.println(user_db);
        });
    }
//    测试不定项参数的查询
    @Test
    public void testListSelect2(){
        List<User_db> userList = userMapper.listSelect2("小",null,null);
        userList.stream().forEach(user_db ->{
            System.out.println(user_db);
        });
    }
    //测试更新。如果符合预期，则其他字段均被修改，age保持不变，且不被替换为null
    @Test
    public void testUpdate(){
        User_db user_db = new User_db(6,"修改",(short) 12,(short) 1,"1222233333");
        user_db.setAge(null);
        userMapper.update(user_db);
    }
    @Test
    public void testDeleteByIds(){
        List<Integer> ids = new ArrayList<>();
        ids.add(6);
        ids.add(7);
        userMapper.deleteByIds(ids);
    }
    @Test
    public void testcommonSelect(){
        List<User_db> userList = userMapper.commonSelect();
        userList.stream().forEach(user_db ->{
            System.out.println(user_db);
        });
    }
}
