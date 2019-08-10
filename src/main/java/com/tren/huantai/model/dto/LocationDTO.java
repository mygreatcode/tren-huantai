package com.tren.huantai.model.dto;

import com.tren.huantai.model.dto.base.OutputConverter;
import com.tren.huantai.model.entity.NewHouseinfoEntity;
import com.tren.huantai.model.entity.LocationEntity;
import com.tren.huantai.model.entity.OldhouseinfoEntity;
import com.tren.huantai.model.entity.RentinghouseinfoEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class LocationDTO implements OutputConverter<LocationDTO, LocationEntity> , Serializable {
    private int id;
    private String loactionid;
    private double longitude;
    private double latitude;
    private String detailedaddress;
    private NewHouseinfoEntity newHouseinfoEntity;
    private OldhouseinfoEntity oldhouseinfoEntity;
    private RentinghouseinfoEntity rentinghouseinfoEntity;
}
