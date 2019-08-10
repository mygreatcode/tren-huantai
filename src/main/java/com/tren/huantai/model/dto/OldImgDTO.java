package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.OldImgEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class OldImgDTO implements OutputConverter<OldImgDTO, OldImgEntity> , Serializable {
    private int id;
    private String imgid;
    private String imgurl;
}
