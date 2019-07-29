package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.UserEntity;
import lombok.Data;

import java.sql.Date;
@Data
public class UserDTO implements OutputConverter<UserDTO, UserEntity> {
    private int id;
    private String name;
    private Date birthday;
    private byte sex;
    private String headimg;
    private String mobilenumber;
    private String phonenumber;
    private String userid;
    private String authority;
}
