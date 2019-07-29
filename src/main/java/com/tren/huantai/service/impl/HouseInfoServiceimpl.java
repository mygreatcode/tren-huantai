package com.tren.huantai.service.impl;

import com.tren.huantai.model.entity.HouseinfoEntity;
import com.tren.huantai.repository.base.HouseInfoRepository;
import com.tren.huantai.service.base.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.webjars\jquery\3.4.1\f9cd2ff7f2da4c3f6839e9d5e5e92b0bbe1cbfb\jquery-3.4.1.jar!\META-INF\resources\webjars\jquery\3.4.1\jquery.js
import java.util.List;
@Service
public class HouseInfoServiceimpl implements HouseInfoService {
    @Autowired
    private HouseInfoRepository houseInfoRepository;
    @Override
    public List<HouseinfoEntity> findall() {
        return houseInfoRepository.findAll();
    }
}
