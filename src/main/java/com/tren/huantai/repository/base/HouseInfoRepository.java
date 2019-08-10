package com.tren.huantai.repository.base;

import com.tren.huantai.model.entity.NewHouseinfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseInfoRepository extends BaseRepository<NewHouseinfoEntity,Long> {
    /**
     * get all recomment house info
     * @return
     */
    @Query(value = "select c from NewHouseinfoEntity c where c.newHouseEntity.recommend=1 and c.locationid=:citycode")
    List<NewHouseinfoEntity> findAllRecomment(@Param("citycode") String citycode);

    /**
     * search info by input
     * @param inputstr
     * @return
     */
    @Query(value = "select c from NewHouseinfoEntity c where c.headline like CONCAT('%',:str,'%') or c.sellingpoints like CONCAT('%',:str,'%') and c.locationid=:citycode")
    List<NewHouseinfoEntity> searchinfo(@Param("str") String inputstr, @Param("citycode")String citycode);


}
