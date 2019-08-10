package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.NewImgEntity;

public class ImgDTO implements OutputConverter<ImgDTO, NewImgEntity> {
    private int id;
    private String imgid;
    private String imgurl;
}
