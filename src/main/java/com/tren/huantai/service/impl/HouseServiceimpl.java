package com.tren.huantai.service.impl;

import com.tren.huantai.model.entity.HouseEntity;
import com.tren.huantai.repository.base.HouseRepository;
import com.tren.huantai.service.base.HouseService;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class HouseServiceimpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;

    @Override
    public HouseEntity addHouseinfo(HouseEntity houseEntity) {
        Assert.notNull(houseEntity," param must not be null");
        return houseRepository.save(houseEntity);
    }

    @Override
    public void removeUser(HouseEntity houseEntity) {
        Assert.notNull(houseEntity," param must not be null");
        houseRepository.delete(houseEntity);
    }

    @Override
    public HouseEntity saveOrUpdateUser(HouseEntity houseEntity) {

        return null;
    }


    @Override
    public HouseEntity findByhouseid(String houseid) {
        Assert.notNull(houseid," param must not be null");
        return houseRepository.findByhouseid(houseid);
    }

    @Override
    public HouseEntity findByuserid(String userid) {
        Assert.notNull(userid," param must not be null");
        return null;
    }


    @Override
    public List<HouseEntity> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public List<HouseEntity> queryPage(Pagination pagination) {

        return null;
    }

}
