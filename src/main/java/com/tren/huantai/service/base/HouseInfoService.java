package com.tren.huantai.service.base;


import com.tren.huantai.model.dto.HouseinfoDTO;
import com.tren.huantai.model.entity.NewHouseinfoEntity;
import lombok.NonNull;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HouseInfoService extends CrudService<NewHouseinfoEntity,Integer> {
    /**
     * search house info by xiaoqu name
     * @param str
     * @return
     */
    List<HouseinfoDTO> searchinfobyxiaoqu(String str);
    /**
     * fuzzy query house info
     * @param str
     * @return
     */
    @NonNull List<HouseinfoDTO> searchinfo(String str,String citycode);
    /**
     * Removes Houseinfo permanently.
     *
     * @param id attachment id must not be null
     * @return attachment detail deleted
     */
    @NonNull
    NewHouseinfoEntity removeHouseinfo(@NonNull Integer id);

    /**
     * Converts to Houseinfo output dto.
     *
     * @param newHouseinfoEntity attachment must not be null
     * @return an attachment output dto
     */
    @NonNull
    HouseinfoDTO convertToDto(@NonNull NewHouseinfoEntity newHouseinfoEntity);

    /**
     * find houseinfo by paging
     * @param page
     * @param size
     * @return
     */
     @NonNull
     Page<NewHouseinfoEntity> findallbypage(int page, int size, String citycode);

    /**
     * findall recomment houseinfo
     */
    @NonNull
    List<HouseinfoDTO> findrecommenthouseinfo(String citycode);
}
