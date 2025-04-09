package org.example.springbootproject01.controller;

import org.example.springbootproject01.Pojo.Area;
import org.example.springbootproject01.Pojo.Result;
import org.example.springbootproject01.service.AreaService;
import org.example.springbootproject01.service.impl.AreaServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AreaController {//三个层次，controller访问Service，Service访问Dao
    @Autowired
    private AreaService areaService;//这里只需要调用Service层进行数据处理，在Service内部又会去访问Dao获取数据

    @RequestMapping("/listArea")
    public Result list(){
        List<Area> areaList = areaService.listArea();
        return Result.success(areaList);
    }
}
