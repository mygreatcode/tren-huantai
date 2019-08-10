package com.tren.huantai.service.impl;

import com.tren.huantai.model.dto.OldhouseinfoDTO;
import com.tren.huantai.model.entity.OldhouseinfoEntity;
import com.tren.huantai.repository.base.BaseRepository;
import com.tren.huantai.repository.base.OldHouseInfoRepository;
import com.tren.huantai.service.base.AbstractCrudService;
import com.tren.huantai.service.base.OldHourseInfoServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OldHourseInfoServiseImpl extends AbstractCrudService<OldhouseinfoEntity,Integer>implements OldHourseInfoServise {

    protected OldHourseInfoServiseImpl(BaseRepository<OldhouseinfoEntity, Integer> repository) {
        super(repository);
    }
@Autowired
private OldHouseInfoRepository oldHouseInfoRepository;
    //@Cacheable(cacheNames = "oldhouse",key = "#citycode")
    @Override
    public List<OldhouseinfoDTO> findoldrecommenthouse(String citycode) {
        Assert.notNull(citycode,"citycode must be not null");
       List< OldhouseinfoEntity > all = oldHouseInfoRepository.findAllRecomment(citycode);
        return all.stream().map(OldhouseinfoEntity -> (OldhouseinfoDTO)new OldhouseinfoDTO().convertFrom(OldhouseinfoEntity)).collect(Collectors.toList());

    }

    //@Cacheable(cacheNames = "oldhouse",key = "#citycode+#str")
    @Override
    public List<OldhouseinfoDTO> searchinfo(String str,String citycode) {
        List<OldhouseinfoEntity> searchinfo = oldHouseInfoRepository.searchinfo(str, citycode);
        return searchinfo.stream().map(oldhouseinfoEntity -> (OldhouseinfoDTO)new OldhouseinfoDTO().convertFrom(oldhouseinfoEntity)).collect(Collectors.toList());
    }

    //@Cacheable(cacheNames = "oldhouse",key = "#root.method+#citycode")
    @Override
    public Page<OldhouseinfoEntity> findallbypage(int page, int size, String citycode) {
        Pageable pageable =  PageRequest.of(page-1, size);
        OldhouseinfoEntity houseinfoEntity=new OldhouseinfoEntity();
        houseinfoEntity.setLocationid(citycode);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("price");
        Page<OldhouseinfoEntity> all = oldHouseInfoRepository.findAll(Example.of(houseinfoEntity,exampleMatcher),pageable);
        return all;

    }
}
