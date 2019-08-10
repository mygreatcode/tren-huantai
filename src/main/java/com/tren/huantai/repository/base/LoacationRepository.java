package com.tren.huantai.repository.base;

import com.tren.huantai.model.entity.LocationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoacationRepository extends BaseRepository<LocationEntity,Integer> {
    /**
     * search info by input xiaoqu
     * @param inputstr
     * @return
     */
    @Query(value = "select * from location c where c.detailedaddress like CONCAT('%',:str,'%')and c.loactionid=:citycode", nativeQuery = true)
    List<LocationEntity> searchinfobyxiaoqu(@Param("str") String inputstr,@Param("citycode")String citycode);
}
