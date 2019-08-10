package com.tren.huantai.service.base;

import com.tren.huantai.model.dto.LocationDTO;
import com.tren.huantai.model.entity.LocationEntity;

import java.util.List;

public interface LocationService extends CrudService<LocationEntity,Integer>{
    /**
     * search house info by xiaoqu
     * @param inputstr
     * @return
     */
    List<LocationDTO> searchinfobyxiaoqu(String inputstr,String citycode);
}
