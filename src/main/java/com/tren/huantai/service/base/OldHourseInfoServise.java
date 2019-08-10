package com.tren.huantai.service.base;

import com.tren.huantai.model.dto.OldhouseinfoDTO;
import com.tren.huantai.model.entity.OldhouseinfoEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OldHourseInfoServise extends CrudService<OldhouseinfoEntity,Integer>{
    /**
     * get all recomment house info
     * @return
     */
    List<OldhouseinfoDTO> findoldrecommenthouse(String citycode);

    /**
     * search house info by str
     * @param str
     * @return
     */
   List<OldhouseinfoDTO> searchinfo(String str,String citycode);


    /**
     * get old house info by paging
     * @param page
     * @param size
     * @param citycode
     * @return
     */
    Page<OldhouseinfoEntity> findallbypage(int page, int size, String citycode);
}
