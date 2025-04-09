package org.example.springbootproject01.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springbootproject01.Pojo.Area;
import org.example.springbootproject01.dao.AreaDao;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component//加上注解后就将类作为bean丢进IOC容器
public class AreaDaoA implements AreaDao {
    @Override
    public List<Area> listArea() {
        String file = this.getClass().getClassLoader().getResource("area.json").getFile();
        System.out.println(file);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Area> areaList = objectMapper.readValue(new File(file), new TypeReference<List<Area>>() {
            });
            return areaList;
        }catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
