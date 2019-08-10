package com.tren.huantai.service.impl;

import com.tren.huantai.model.dto.RentingHouseInfoDTO;
import com.tren.huantai.model.entity.OldhouseinfoEntity;
import com.tren.huantai.model.entity.RentinghouseinfoEntity;
import com.tren.huantai.repository.base.BaseRepository;
import com.tren.huantai.repository.base.RentingHouseInfoRepository;
import com.tren.huantai.service.base.AbstractCrudService;
import com.tren.huantai.service.base.RentingHouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentingHouseInfoServiceImpl extends AbstractCrudService<RentinghouseinfoEntity ,Integer> implements RentingHouseInfoService {
  @Autowired
  RentingHouseInfoRepository rentingHouseInfoRepository;
    protected RentingHouseInfoServiceImpl(BaseRepository<RentinghouseinfoEntity, Integer> repository) {
        super(repository);
    }

    @Cacheable(cacheNames = "rentinghouse",key = "#str+#citycode")
    @Override
    public List<RentingHouseInfoDTO> searchinfo(String str,String citycode) {
        Assert.notNull(str,"input info mustbe not null");
        Assert.notNull(citycode,"citycode must be not null");
        List<RentinghouseinfoEntity> searchinfo = rentingHouseInfoRepository.searchinfo(str, citycode);
        return  searchinfo.stream().map(rentinghouseinfoEntity ->(RentingHouseInfoDTO) new RentingHouseInfoDTO().convertFrom(rentinghouseinfoEntity)).collect(Collectors.toList());
    }

    @Cacheable(cacheNames = "rentinghouse",key = "#page")
    @Override
    public Page<RentinghouseinfoEntity> findallbypage(int page, int size, String citycode) {
        Pageable pageable =  PageRequest.of(page-1, size);
        RentinghouseinfoEntity houseinfoEntity=new RentinghouseinfoEntity();
        houseinfoEntity.setLocationid(citycode);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("price");
        Page<RentinghouseinfoEntity> all = rentingHouseInfoRepository.findAll(Example.of(houseinfoEntity,exampleMatcher),pageable);
        return all;
    }

    @Cacheable(cacheNames = "rentinghouse",key = "#root.method+#citycode")
    @Override
    public List<RentingHouseInfoDTO> findrentingrecommenthouse(String citycode) {
        List<RentinghouseinfoEntity> allRecomment = rentingHouseInfoRepository.findAllRecomment(citycode);
        return allRecomment.stream().map(rentinghouseinfoEntity ->(RentingHouseInfoDTO) new RentingHouseInfoDTO().convertFrom(rentinghouseinfoEntity)).collect(Collectors.toList());
    }
}
