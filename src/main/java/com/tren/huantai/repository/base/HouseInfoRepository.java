package com.tren.huantai.repository.base;

import com.tren.huantai.model.entity.HouseinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseInfoRepository extends JpaRepository<HouseinfoEntity,Long> {
    /**
     * get all house info
     * @return
     */
    @Override
    List<HouseinfoEntity> findAll();
}
