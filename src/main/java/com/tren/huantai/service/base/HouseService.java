package com.tren.huantai.service.base;

import com.tren.huantai.model.entity.NewHouseEntity;
import javafx.scene.control.Pagination;

import java.util.List;

public interface HouseService {
    /**
     * 添加
     * @param newHouseEntity
     */
    public NewHouseEntity addHouseinfo(NewHouseEntity newHouseEntity);


    /**
     * 删除
     * @param newHouseEntity
     */
    public void removeUser(NewHouseEntity newHouseEntity);


    /**
     * 保存或修改
     * @param newHouseEntity
     */
    public NewHouseEntity saveOrUpdateUser(NewHouseEntity newHouseEntity);


    /**
     * 根据houseid查询单个
     * @param houseid
     * @return
     */
    public NewHouseEntity findByhouseid(String houseid);

    /**
     * 根据用户名查询
     * @param userid
     * @return
     */
    public NewHouseEntity findByuserid(String userid);


    /**
     * 查询所有
     * @return
     */
    public List<NewHouseEntity> findAll();

    /**
     * 分页查询
     * @return
     */
    public List<NewHouseEntity> queryPage(Pagination pagination);

}
