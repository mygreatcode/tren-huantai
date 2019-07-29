package com.tren.huantai.service.base;

import com.tren.huantai.model.entity.HouseinfoEntity;

import java.util.List;

public interface HouseInfoService {
    /**
     * 获取所有信息
     * @return
     */
    public List<HouseinfoEntity> findall();
}
