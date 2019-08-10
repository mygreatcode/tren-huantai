package com.tren.huantai.controller;

import com.alibaba.fastjson.JSONObject;
import com.tren.huantai.model.dto.HouseinfoDTO;
import com.tren.huantai.model.dto.LocationDTO;
import com.tren.huantai.model.dto.OldhouseinfoDTO;
import com.tren.huantai.model.dto.RentingHouseInfoDTO;
import com.tren.huantai.service.base.HouseInfoService;
import com.tren.huantai.service.base.LocationService;
import com.tren.huantai.service.base.OldHourseInfoServise;
import com.tren.huantai.service.base.RentingHouseInfoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchHouseInfoController {
@Autowired
HouseInfoService houseInfoService;
@Autowired
OldHourseInfoServise oldHourseInfoServise;
@Autowired
RentingHouseInfoService rentingHouseInfoService;
@Autowired
LocationService locationService;
    @RequestMapping("/house.search")
    public String searchehouse(String searchinput,String citycode){
        JSONObject jsonObject=new JSONObject();
        if (searchinput.length()>0||!searchinput.isEmpty()) {
            @NonNull List<HouseinfoDTO> searchinfo = houseInfoService.searchinfo(searchinput,citycode);
            if (!searchinfo.isEmpty())
              jsonObject.put("info",searchinfo);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/oldhouse.search")
    public String searcheOldhouse(String searchinput,String citycode){
        JSONObject jsonObject=new JSONObject();
        if (searchinput.length()>0||!searchinput.isEmpty()) {
            List<OldhouseinfoDTO> searchinfo = oldHourseInfoServise.searchinfo(searchinput,citycode);
            if (!searchinfo.isEmpty())
                jsonObject.put("info",searchinfo);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/rentinghouse.search")
    public String searcheRentinghouse(String searchinput,String citycode){
        JSONObject jsonObject=new JSONObject();
        if (searchinput.length()>0||!searchinput.isEmpty()) {
        List<RentingHouseInfoDTO> searchinfo = rentingHouseInfoService.searchinfo(searchinput,citycode);
            if (!searchinfo.isEmpty())
                jsonObject.put("info",searchinfo);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/xiaoqu.search")
    public String searchexiaoquhouse(String searchinput,String citycode){
        JSONObject jsonObject=new JSONObject();
        if (searchinput.length()>0||!searchinput.isEmpty()) {
        List<LocationDTO> searchinfobyxiaoqu = locationService.searchinfobyxiaoqu(searchinput,citycode);
            for (LocationDTO l:searchinfobyxiaoqu) {
               System.out.println(l.getNewHouseinfoEntity().getHeadline());
            }
            if (!searchinfobyxiaoqu.isEmpty())
                jsonObject.put("info",searchinfobyxiaoqu);
        }
        return jsonObject.toString();
    }
}
