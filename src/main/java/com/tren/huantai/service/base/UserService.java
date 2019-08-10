package com.tren.huantai.service.base;

import com.tren.huantai.model.dto.UserDTO;
import com.tren.huantai.model.entity.UserEntity;
import org.springframework.data.repository.query.Param;

public interface UserService extends CrudService<UserEntity, Integer> {
    /**
     * add user
     */
    void userregister( String nickname,String password, String birthday,String sex, String mobilenumber,String phonenumber,String name);
}
