package com.tren.huantai.service.impl;

import com.tren.huantai.model.dto.LocationDTO;
import com.tren.huantai.model.entity.LocationEntity;
import com.tren.huantai.repository.base.BaseRepository;
import com.tren.huantai.repository.base.LoacationRepository;
import com.tren.huantai.service.base.AbstractCrudService;
import com.tren.huantai.service.base.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl extends AbstractCrudService<LocationEntity,Integer> implements LocationService {
    protected LocationServiceImpl(BaseRepository<LocationEntity, Integer> repository) {
        super(repository);
    }
    @Autowired
    LoacationRepository loacationRepository;

    @Override
    public List<LocationDTO> searchinfobyxiaoqu(String inputstr,String citycode) {
        List<LocationEntity> searchinfobyxiaoqu = loacationRepository.searchinfobyxiaoqu(inputstr,citycode);
        return searchinfobyxiaoqu.stream().map(LocationEntity -> (LocationDTO)new LocationDTO().convertFrom(LocationEntity)).collect(Collectors.toList());

    }
}
