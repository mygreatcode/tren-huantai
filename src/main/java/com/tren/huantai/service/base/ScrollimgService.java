package com.tren.huantai.service.base;

import com.tren.huantai.model.dto.ScrollimgDTO;

import java.util.List;

public interface ScrollimgService {
    /**
     * get all scroll images path
     */
  List<ScrollimgDTO> findscrollsmg();
}
