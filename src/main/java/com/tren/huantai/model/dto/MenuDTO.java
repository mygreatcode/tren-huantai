package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.MenuEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class MenuDTO implements OutputConverter<MenuDTO, MenuEntity>, Serializable {
    private int id;
    private String menu;
    private String url;
    private int menuid;
}
