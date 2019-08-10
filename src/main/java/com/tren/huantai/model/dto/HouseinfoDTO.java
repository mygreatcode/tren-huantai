package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.*;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Data
@ToString
public class HouseinfoDTO implements OutputConverter<HouseinfoDTO, NewHouseinfoEntity>,Serializable{
    private int id;
    private String headline;//标题
    private int price;//价格
    private String housetype;//房屋类型 （住房/商铺）
    private String area;//面积
    private String locationid;
    private Date buildingtime;//建筑时间
    private String buildinghead;//朝向
    private String floor;//楼层
    private String downpayment;//最低首付 （别墅 119.4 万（首付比例：30%））
    private String monthlypay;//月供 （别墅 14786.05元 （按最低首付，20年等额本息））
    private String decorated;//装修 （毛坯）
    private String sellingpoints;//卖点
    private String houseencoding;//房屋编号
    private Timestamp releasetime; //发布时间
    private String chanquannianxian;//产权年限
    private String tag;
    private NewHouseEntity newHouseEntity;
    private List<NewImgEntity> imgEntity;
    private LocationEntity locationEntity;
    private  HouseStructureEntity houseStructureEntity;
    public int getUnitprice() {
        log.info("面积"+getArea());
        log.info("总价"+getPrice());
        log.info("单价"+Integer.valueOf(getArea())/getPrice());
        return getPrice()/Integer.valueOf(getArea());
    }
}
