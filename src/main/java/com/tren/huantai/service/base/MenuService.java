package com.tren.huantai.service.base;

import com.tren.huantai.model.dto.MenuDTO;
import com.tren.huantai.model.entity.MenuEntity;
import lombok.NonNull;

import java.util.List;

public interface MenuService extends CrudService<MenuEntity,Integer> {
    /**
     * Converts to Houseinfo output dto.
     *
     * @param menuEntity menu must not be null
     * @return an attachment output dto
     */
    @NonNull
    MenuDTO convertToDto(@NonNull MenuEntity menuEntity);

    /**
     * get all menu info
     */
    List<MenuDTO> findmenu();
}
