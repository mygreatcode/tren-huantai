package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.RentinghouseEntity;
import com.tren.huantai.model.entity.ScrollimgEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ScrollimgDTO implements OutputConverter<ScrollimgDTO, ScrollimgEntity> , Serializable {
    private int id;
    private String imgpath;
    private int imgid;
    private String imgtitle;
    private String imgdetails;
}
