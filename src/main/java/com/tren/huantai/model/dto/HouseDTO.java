package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.NewHouseEntity;
import com.tren.huantai.model.entity.NewHouseinfoEntity;
import com.tren.huantai.model.entity.UserinfoEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class HouseDTO implements OutputConverter<HouseDTO, NewHouseEntity> , Serializable {
    private int id;
    private String houseid;
    private String userid;
    private String state;
    private int recommend;
    private NewHouseinfoEntity newHouseinfoEntity;
    private UserinfoEntity userinfoEntity;
}
