package com.tren.huantai.repository.base;

import com.tren.huantai.model.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface HouseRepository extends JpaRepository<HouseEntity,Long> {
    /**
     * 查询所有
     * @return
     */
     @Query("select u from HouseEntity u")
     List<HouseEntity> findAll();

    /**
     * 按houseid查询单个
     */
    @Query("select u from HouseEntity u where houseid=:houseid")
    HouseEntity findByhouseid(@Param("houseid") String houseid);


    /**
     *     private int id;
     *     private String houseid;
     *     private String userid;
     *     private String state;
     *     添加信息
     * @param houseEntity
     * @return
     */
    @Modifying
    @Transactional
   @Query(value = "insert into HouseEntity(houseid,userid,state) values(:houseEntity.houseid,:houseEntity.userid,:houseEntity.state)",nativeQuery = true)
    int addHouseinfo(@Param("houseEntity")HouseEntity houseEntity);


}
