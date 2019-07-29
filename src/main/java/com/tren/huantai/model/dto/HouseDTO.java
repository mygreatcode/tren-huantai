package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.HouseEntity;
import lombok.Data;

@Data
public class HouseDTO implements OutputConverter<HouseDTO, HouseEntity> {
    private int id;
    private String houseid;
    private String userid;
    private String state;
}
