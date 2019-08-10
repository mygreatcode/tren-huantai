package com.tren.huantai.service.impl;

import com.tren.huantai.model.entity.NewHouseEntity;
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
    public NewHouseEntity addHouseinfo(NewHouseEntity newHouseEntity) {
        Assert.notNull(newHouseEntity," param must not be null");
        return houseRepository.save(newHouseEntity);
    }

    @Override
    public void removeUser(NewHouseEntity newHouseEntity) {
        Assert.notNull(newHouseEntity," param must not be null");
        houseRepository.delete(newHouseEntity);
    }

    @Override
    public NewHouseEntity saveOrUpdateUser(NewHouseEntity newHouseEntity) {

        return null;
    }


    @Override
    public NewHouseEntity findByhouseid(String houseid) {
        Assert.notNull(houseid," param must not be null");
        return houseRepository.findByhouseid(houseid);
    }

    @Override
    public NewHouseEntity findByuserid(String userid) {
        Assert.notNull(userid," param must not be null");
        return null;
    }


    @Override
    public List<NewHouseEntity> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public List<NewHouseEntity> queryPage(Pagination pagination) {

        return null;
    }

}
