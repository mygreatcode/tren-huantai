package com.tren.huantai.service.impl;

import com.tren.huantai.model.dto.MenuDTO;
import com.tren.huantai.model.entity.MenuEntity;
import com.tren.huantai.repository.base.BaseRepository;
import com.tren.huantai.repository.base.MenuRepository;
import com.tren.huantai.service.base.AbstractCrudService;
import com.tren.huantai.service.base.MenuService;
import javassist.NotFoundException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuServiceimpl extends AbstractCrudService<MenuEntity, Integer> implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    protected MenuServiceimpl(BaseRepository<MenuEntity, Integer> repository) {
        super(repository);
    }

    @Override
    public @NonNull MenuDTO convertToDto(@NonNull MenuEntity menuEntity) {
        return null;
    }

    @Cacheable(cacheNames = "menu",key = "#root.method")
    @Override
    public List<MenuDTO> findmenu() {
        List<MenuEntity> all = menuRepository.findAll();
        return all.stream().map(menuEntity -> (MenuDTO)new MenuDTO().convertFrom(menuEntity)).collect(Collectors.toList());
    }


}
