package org.example.springbootproject01.service.impl;

import org.example.springbootproject01.Pojo.Area;
import org.example.springbootproject01.dao.AreaDao;
import org.example.springbootproject01.dao.impl.AreaDaoA;
import org.example.springbootproject01.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AreaServiceA implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> listArea() {
        List<Area> areaList = areaDao.listArea();
        for(Area area : areaList){
            area.setId("0");
        }
        return areaList;
    }
}
