package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
public class UserInfoDTO implements OutputConverter<UserInfoDTO, UserinfoEntity> , Serializable {
    private int id;
    private String name;
    private Date birthday;
    private byte sex;
    private String headimgpath;
    private String mobilenumber;
    private String phonenumber;
    private UserEntity userEntity;
    private Set<NewHouseEntity> newHouseEntity;
    private  Set<OldhouseEntity> oldhouseEntities;
    private List<RentinghouseEntity> rentinghouseEntities;
}
