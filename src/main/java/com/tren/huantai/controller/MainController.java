package com.tren.huantai.controller;

import com.tren.huantai.model.dto.*;
import com.tren.huantai.model.entity.NewHouseEntity;
import com.tren.huantai.service.base.*;
import com.tren.huantai.service.impl.HouseServiceimpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class MainController {
    @Autowired(required=true)
    HouseInfoService houseinfoService;
    @Autowired(required=true)
    HouseServiceimpl houseService;
    @GetMapping("/demo.pc")
    public ModelAndView index(ModelAndView mv) {
        NewHouseEntity byhouseid = houseService.findByhouseid("123");
        mv.getModel().put("name",byhouseid);
       mv.setViewName("demo.html");
        return mv;
    }

    @GetMapping("/demo.mobile")
    public ModelAndView mobile(ModelAndView mv) {
        NewHouseEntity byhouseid = houseService.findByhouseid("123");
        mv.getModel().put("name",byhouseid);
        mv.setViewName("mobile.html");
        return mv;
    }
    @RequestMapping("/allhouse.action")
    public void allhouse(){
     //   List<NewHouseinfoEntity> houseEntities= houseinfoService.findall();


}


    @RequestMapping("/house.action")
    public void house(String houseid){
          NewHouseEntity houseEntities= houseService.findByhouseid(houseid);
          System.out.println(houseEntities.toString());

    }

//    @RequestMapping("/house.add")
//    public void addhouse(){
//        NewHouseEntity newHouseEntity=new NewHouseEntity();
//        newHouseEntity.setHouseid("1314520");
//        newHouseEntity.setId(1);
//        newHouseEntity.setState("0");
//        newHouseEntity.setUserid("112233");
//        NewHouseinfoEntity newHouseinfoEntity=new NewHouseinfoEntity();
//        newHouseinfoEntity.setArea("123");
//
//        newHouseinfoEntity.setBuildinghead("x");
//        newHouseEntity.setNewHouseinfoEntity(newHouseinfoEntity);
//      System.out.println( houseService.addHouseinfo(newHouseEntity));
 //   }

    @RequestMapping("/house.del")
    public void delhouse(){
        NewHouseEntity newHouseEntity =new NewHouseEntity();
        newHouseEntity.setState("0");
      houseService.removeUser(newHouseEntity);
    }


    @Autowired
    ScrollimgService scrollimgService;
    @Autowired
    MenuService menuService;
    @Autowired
    OldHourseInfoServise oldHourseInfoServise;
    @Autowired
    RentingHouseInfoService rentingHouseInfoService;
    /**
     * show huantai  house property main page
     * @param mv
     * @return
     */
    @RequestMapping("/houseinfo.mainpage")
    public ModelAndView mainpage(ModelAndView mv,String citycode){
        String code=citycode;
        Map<String, Object> model = mv.getModel();
        List<HouseinfoDTO> findrecommenthouseinfo = houseinfoService.findrecommenthouseinfo(citycode);//get all recomment new house info
        List<ScrollimgDTO> findscrollsmg = scrollimgService.findscrollsmg();//get all scroll image path
        List<MenuDTO> findmenu = menuService.findmenu();//get all title menu
        List<OldhouseinfoDTO> findoldrecommenthouse = oldHourseInfoServise.findoldrecommenthouse(citycode);
        List<RentingHouseInfoDTO> findrentingrecommenthouse = rentingHouseInfoService.findrentingrecommenthouse(citycode);
        model.put("findscrollsmg",findscrollsmg);
        model.put("citycode",code);
        model.put("menu",findmenu);
        model.put("recommenthouseinfo",findrecommenthouseinfo);
        model.put("rentingrecommenthouse",findrentingrecommenthouse);
        model.put("oldrrecommenthouseinfo",findoldrecommenthouse);
        for (OldhouseinfoDTO o:findoldrecommenthouse) {
            System.out.println(o.getHeadline());
        }
        mv.setViewName("demo");
        return mv;
    }
}
