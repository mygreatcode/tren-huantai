package com.tren.huantai.repository.base;

import com.tren.huantai.model.entity.NewHouseEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface HouseRepository extends BaseRepository<NewHouseEntity,Long> {
    /**
     * 查询所有
     * @return
     */
     @Query("select u from NewHouseEntity u")
     List<NewHouseEntity> findAll();

    /**
     * 按houseid查询单个
     */
    @Query("select u from NewHouseEntity u where houseid=:houseid")
    NewHouseEntity findByhouseid(@Param("houseid") String houseid);


    /**
     *     private int id;
     *     private String houseid;
     *     private String userid;
     *     private String state;
     *     添加信息
     * @param newHouseEntity
     * @return
     */
    @Modifying
    @Transactional
   @Query(value = "insert into NewHouseEntity(houseid,userid,state) values(:newHouseEntity.houseid,:newHouseEntity.userid,:newHouseEntity.state)",nativeQuery = true)
    int addHouseinfo(@Param("newHouseEntity") NewHouseEntity newHouseEntity);


}
