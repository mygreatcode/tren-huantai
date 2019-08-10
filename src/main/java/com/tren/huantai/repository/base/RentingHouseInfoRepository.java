package com.tren.huantai.repository.base;

import com.tren.huantai.model.entity.RentinghouseinfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentingHouseInfoRepository extends BaseRepository<RentinghouseinfoEntity,Integer> {
    @Query(value = "select c from RentinghouseinfoEntity c where c.headline like CONCAT('%',:str,'%') and c.locationid=:citycode")
    List<RentinghouseinfoEntity> searchinfo(@Param("str") String inputstr,@Param("citycode")String citycode);

    @Query(value = "select c from RentinghouseinfoEntity c where c.rentinghouseEntity.recommend=1 and c.locationid=:citycode")
    List<RentinghouseinfoEntity>   findAllRecomment(@Param("citycode")String citycode);
}
