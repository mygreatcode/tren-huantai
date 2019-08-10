package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Set;
@Slf4j
@Data
public class RentingHouseInfoDTO implements OutputConverter<RentingHouseInfoDTO, RentinghouseinfoEntity> , Serializable {
    private int id;
    private String headline;//标题
    private Integer price;//价格
    private String payway;//支付方式 (押一付三)
    private String area;//面积
    private String housestructure;//房屋结构
    private String locationid;//位置编号
    private String floor;//楼层
    private String decorated;//装修详细信息
    private String buildinghead;//房屋朝向
    private String housecode;//房屋编号
    private DeployEntity deployEntity;//房屋配套 （床、宽带、空调、热水器、洗衣机、电视、冰箱、暖气）
    private String describe;//租房详细描述 （无中介费，光线明亮，家具家电齐全，配有300M光纤）
    private String tag;
    private Set<RentingImgEntity> rentingImgEntity;
    private LocationEntity locationEntity;
    private  HouseStructureEntity houseStructureEntity;
    private RentinghouseEntity rentinghouseEntity;
    private String rentingpoint;
    public int getUnitprice() {
        log.info("面积"+getArea());
        log.info("总价"+getPrice());
        log.info("单价"+Integer.valueOf(getArea())/getPrice());
        return getPrice()/Integer.valueOf(getArea());
    }
}
