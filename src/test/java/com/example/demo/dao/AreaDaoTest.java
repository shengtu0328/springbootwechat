package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areas = areaDao.queryArea();
        assertEquals(2,areas.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    public void insertArea() {

        Area area=new Area();
        area.setAreaName("北苑");
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        area.setPriority(4);
        areaDao.insertArea(area);
    }

    @Test
    public void updateArea() {
        Area area=new Area();
        area.setAreaId(5);
        area.setAreaName("总部");
        assertEquals(1,areaDao.updateArea(area));
    }

    @Test
    public void deleteArea() {

        assertEquals(1,areaDao.deleteArea(5));
    }
}