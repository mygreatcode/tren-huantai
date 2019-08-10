package com.tren.huantai.service.base;


import com.tren.huantai.model.dto.RentingHouseInfoDTO;
import com.tren.huantai.model.entity.RentinghouseinfoEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RentingHouseInfoService extends CrudService<RentinghouseinfoEntity,Integer>{
    /**
     * search rentinghouse info by str
     * @param str
     * @return
     */
   List<RentingHouseInfoDTO> searchinfo(String str,String citycode);



    /**
     * get renting house info by paging
     * @param page
     * @param size
     * @param citycode
     * @return
     */
    Page<RentinghouseinfoEntity> findallbypage(int page, int size, String citycode);

    /**
     * get all recomment house info
     * @return
     */
    List<RentingHouseInfoDTO> findrentingrecommenthouse(String citycode);
}
