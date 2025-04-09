package org.example.springbootproject01.controller;

import org.example.springbootproject01.Pojo.Result;
import org.example.springbootproject01.Pojo.User;
import org.example.springbootproject01.Pojo.User_db;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.springbootproject01.service.User_dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class Hellocontroller {
    private static final Logger log = LoggerFactory.getLogger(Hellocontroller.class);

    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("hello world");
        return Result.success("hello world");
    }

    @RequestMapping("/param")
    public Result param(String name,@RequestParam(name="aa")int age){//更改请求名称，注意原key'age'被无效化
        System.out.println(name + "今年" + age + "岁了");
        return Result.success(name + "今年" + age + "岁了");
    }

    @RequestMapping("/dateparam")//日期格式
    public Result dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return Result.success(updateTime);
    }
    @RequestMapping("/Pojo")//映射到类,注意映射到类时一是类型要一一对应，二是要传json格式的数据
    public Result Pojo(@RequestBody User user){
        System.out.println(user.toString());
        return Result.success(user.toString());
    }
    @RequestMapping("/path/{id}/{name}")//占位符
    public Result pathparam(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id+" "+name);
        return Result.success(id+" "+name);
    }
/*
* 这里开始是新的测试，将按照controller-service-mapper的顺序测试mapper替换dao后访问数据库的效果
* */
    @Autowired
    private User_dbService User_dbService;
    //GetMapping注解将该路径的请求方式限制为了GET，使用其他方法将会返回405错误
    @GetMapping("/dbSearchTest")
    public Result dbSearchTest(){
        List<User_db> user_db = User_dbService.listUser_db();
        return Result.success(user_db);
    }
    @DeleteMapping("/dbDeleteTest/{id}")
    public Result dbDeleteTest(@PathVariable Integer id){
        User_dbService.deleteUser_db(id);
        return Result.success();
    }
    @PostMapping("/dbInsertTest")
    public Result dbInsertTest(@RequestBody User_db user_db){
        User_dbService.insertUser_db(user_db);
        log.info("插入数据成功:{}", user_db);
        return Result.success();
    }
}
