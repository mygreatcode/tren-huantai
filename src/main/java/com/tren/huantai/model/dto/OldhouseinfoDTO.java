package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
@Slf4j
@Data
public class OldhouseinfoDTO implements OutputConverter<OldhouseinfoDTO, OldhouseinfoEntity>, Serializable {
    private int id;
    private String headline;//标题
    private int price;//价格
    private String area;//面积
    private String housetype;//房屋类型 住房/商铺
    private String locationid;//位置编码
    private Date buildingtime;//建房时间
    private String buildinghead;//房屋朝向
    private String floor;//楼层
    private String heatingsystem;//
    private String housenianxian;//房屋年限 （满五年）
    private String chanquannianxian;//产权年限
    private String mortgageinfo;//抵押信息
    private String havecertificate;//证件
    private String sellingpoints;//卖点
    private String whoproperty;//产权所属
    private String deployid;//房屋配套 （床、宽带、空调、热水器、洗衣机、电视、冰箱、暖气）
    private String downpayment;//最低首付 （别墅 119.4 万（首付比例：30%））
    private String monthlypay;//月供 （别墅 14786.05元 （按最低首付，20年等额本息））
    private String tag;
    private OldhouseEntity oldhouseEntity;
    private Set<OldImgEntity>  oldimgEntity;
    private LocationEntity locationEntity;
    private DeployEntity deployEntity;
    private  HouseStructureEntity houseStructureEntity;
    public int getUnitprice() {
        log.info("面积"+getArea());
        log.info("总价"+getPrice());
        log.info("单价"+Integer.valueOf(getArea())/getPrice());
        return getPrice()/Integer.valueOf(getArea());
    }
}
