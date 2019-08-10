package com.tren.huantai.model.dto;


import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.OldhouseEntity;
import com.tren.huantai.model.entity.OldhouseinfoEntity;
import com.tren.huantai.model.entity.UserinfoEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class OldhouseDTO implements OutputConverter<OldhouseDTO, OldhouseEntity> , Serializable {
    private int id;
    private String oldhouseid;
    private String userid;
    private String state;
    private UserinfoEntity oldhouseuserinfo;
    private OldhouseinfoEntity oldhouseinfoEntity;
}
