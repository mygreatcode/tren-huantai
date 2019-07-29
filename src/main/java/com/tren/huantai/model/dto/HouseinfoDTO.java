package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.HouseinfoEntity;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
@Data
public class HouseinfoDTO implements OutputConverter<HouseinfoDTO, HouseinfoEntity> {
    private int id;
    private String houseid;
    private String headline;
    private int price;
    private String housetype;
    private String area;
    private String previewimgurl;
    private String xiaoqu;
    private String location;
    private Date buildingtime;
    private String buildinghead;
    private String floor;
    private int unitprice;
    private String downpayment;
    private String monthlypay;
    private String decorated;
    private String sellingpoints;
    private String houseencoding;
    private Timestamp releasetime;
}
