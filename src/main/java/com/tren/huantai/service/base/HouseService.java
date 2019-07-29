package com.tren.huantai.service.base;

import com.tren.huantai.model.entity.HouseEntity;
import javafx.scene.control.Pagination;

import java.util.List;

public interface HouseService {
    /**
     * 添加
     * @param houseEntity
     */
    public HouseEntity addHouseinfo(HouseEntity houseEntity);


    /**
     * 删除
     * @param houseEntity
     */
    public void removeUser(HouseEntity houseEntity);


    /**
     * 保存或修改
     * @param houseEntity
     */
    public HouseEntity saveOrUpdateUser(HouseEntity houseEntity);


    /**
     * 根据houseid查询单个
     * @param houseid
     * @return
     */
    public HouseEntity findByhouseid(String houseid);

    /**
     * 根据用户名查询
     * @param userid
     * @return
     */
    public HouseEntity findByuserid(String userid);


    /**
     * 查询所有
     * @return
     */
    public List<HouseEntity> findAll();

    /**
     * 分页查询
     * @return
     */
    public List<HouseEntity> queryPage(Pagination pagination);

}
