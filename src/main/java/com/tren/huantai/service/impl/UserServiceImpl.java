package com.tren.huantai.service.impl;

import com.tren.huantai.model.entity.UserEntity;
import com.tren.huantai.model.entity.UserinfoEntity;
import com.tren.huantai.repository.base.BaseRepository;
import com.tren.huantai.repository.base.UserRepository;
import com.tren.huantai.service.base.AbstractCrudService;
import com.tren.huantai.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@Service
public class UserServiceImpl extends AbstractCrudService<UserEntity ,Integer> implements UserService {
    @Autowired
    private UserRepository userRepository;

    protected UserServiceImpl(BaseRepository<UserEntity, Integer> repository) {
        super(repository);
    }


    @Override
    public void userregister( String nickname,String password, String birthday,String sex, String mobilenumber,String phonenumber,String name) {
        UserEntity userEntity=new UserEntity();
        userEntity.setNickname(nickname);
        userEntity.setPassword(password);
        UserinfoEntity userinfoEntity=new UserinfoEntity();
        java.util.Date d = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
               d = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userinfoEntity.setBirthday(new Date(d.getTime()));
        userinfoEntity.setMobilenumber(mobilenumber);
        userinfoEntity.setName(name);
        userinfoEntity.setPhonenumber(phonenumber);
        userinfoEntity.setSex(Byte.valueOf(sex));
        userEntity.setUserinfoEntity(userinfoEntity);
        userinfoEntity.setNewHouseEntity(null);
        userRepository.save(userEntity);
    }
}
