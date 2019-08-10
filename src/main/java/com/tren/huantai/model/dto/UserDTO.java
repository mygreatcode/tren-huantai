package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.UserEntity;
import com.tren.huantai.model.entity.UserinfoEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements OutputConverter<UserDTO, UserEntity> , Serializable {
    private int id;
    private String nickname;
    private String userid;
    private String password;
    private String authority;
    private UserinfoEntity userinfoEntity;
}
