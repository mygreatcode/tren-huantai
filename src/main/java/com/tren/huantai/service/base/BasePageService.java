package com.tren.huantai.service.base;

import com.tren.huantai.model.entity.HouseinfoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasePageService<info extends HouseinfoEntity> {
    /**
     * get all page info
     * @return
     */
    List<info> listAll();

}
