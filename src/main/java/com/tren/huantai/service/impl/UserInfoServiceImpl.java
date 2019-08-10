package com.tren.huantai.service.impl;

import com.tren.huantai.model.entity.UserinfoEntity;
import com.tren.huantai.repository.base.BaseRepository;
import com.tren.huantai.service.base.AbstractCrudService;
import com.tren.huantai.service.base.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends AbstractCrudService<UserinfoEntity,Integer> implements UserInfoService {


    protected UserInfoServiceImpl(BaseRepository<UserinfoEntity, Integer> repository) {
        super(repository);
    }
}
