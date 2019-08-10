package com.tren.huantai.service.impl;

import com.tren.huantai.model.dto.ScrollimgDTO;
import com.tren.huantai.model.entity.ScrollimgEntity;
import com.tren.huantai.repository.base.ScrollImgRepository;
import com.tren.huantai.service.base.ScrollimgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ScrollImgServiceImpl implements ScrollimgService {
    @Autowired
    private ScrollImgRepository scrollImgRepository;
    @Cacheable(cacheNames = "scrollimg",key = "#root.method")
    @Override
    public List<ScrollimgDTO> findscrollsmg() {
        List<ScrollimgEntity> all = scrollImgRepository.findAll();
        List<ScrollimgDTO> collect = all.stream().map(ScrollimgEntity -> (ScrollimgDTO) new ScrollimgDTO().convertFrom(ScrollimgEntity)).collect(Collectors.toList());
        return collect;
    }
}
