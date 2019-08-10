package com.tren.huantai.repository.base;

import com.tren.huantai.model.entity.OldhouseinfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OldHouseInfoRepository extends BaseRepository<OldhouseinfoEntity,Integer>{
    @Query(value = "select * from oldhouseinfo c where c.headline like CONCAT('%',:str,'%') AND c.locationid=:citycode", nativeQuery = true)
    List<OldhouseinfoEntity> searchinfo(@Param("str") String inputstr,@Param("citycode")String citycode);

    @Query(value = "select c from OldhouseinfoEntity c where c.oldhouseEntity.recommend=1 and c.locationid=:citycode")
    List<OldhouseinfoEntity>   findAllRecomment(@Param("citycode")String citycode);
}
