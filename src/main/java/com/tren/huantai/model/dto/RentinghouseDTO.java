package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.OldhouseinfoEntity;
import com.tren.huantai.model.entity.RentinghouseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class RentinghouseDTO implements OutputConverter<RentinghouseDTO, RentinghouseEntity>, Serializable {
    private int id;
    private String rentinghouseid;
    private String userid;
    private Integer state;
}
