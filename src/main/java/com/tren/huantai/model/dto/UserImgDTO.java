package com.tren.huantai.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserImgDTO implements  Serializable {
    private int id;
    private String imgid;
    private String imgurl;
}
