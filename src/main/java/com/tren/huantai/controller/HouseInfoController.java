package com.tren.huantai.controller;

import com.tren.huantai.model.dto.HouseinfoDTO;
import com.tren.huantai.model.dto.MenuDTO;
import com.tren.huantai.model.dto.OldhouseinfoDTO;
import com.tren.huantai.model.dto.RentingHouseInfoDTO;
import com.tren.huantai.model.entity.*;
import com.tren.huantai.repository.base.HouseRepository;
import com.tren.huantai.repository.base.UserInfoRepository;
import com.tren.huantai.service.base.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.internal.util.collections.IdentitySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@RestController
public class HouseInfoController {
    @Autowired(required=true)
    HouseInfoService houseinfoService;
    @Autowired
    ScrollimgService scrollimgService;
    @Autowired
    MenuService menuService;
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    HouseRepository houseRepository;

    @RequestMapping("/huantai.test")
    public String test(int page,String citycode){
        int size=5;
        Page<NewHouseinfoEntity> findallbypage = houseinfoService.findallbypage(page, size,citycode);
  return findallbypage.getContent().toString();
    }

    /**
     * get new house info by paging
     * @param mv
     * @param page
     * @return
     */
    @RequestMapping("/huantai.newhouseinfo")
    public ModelAndView  getnewhousepage(ModelAndView mv, @RequestParam(defaultValue = "1",value = "page")int page, String citycode){
        int size=1;
        String code=citycode;
        @NonNull
        Page<NewHouseinfoEntity> findallbypage = houseinfoService.findallbypage(page, size,code);
        List<MenuDTO> findmenu = menuService.findmenu();//get all title menu
        List<NewHouseinfoEntity> content = findallbypage.getContent();
        List<HouseinfoDTO> collect = content.stream().map(houseinfoEntity ->(HouseinfoDTO) new HouseinfoDTO().convertFrom(houseinfoEntity)).collect(Collectors.toList());
        mv.getModel().put("houseinfo",collect);
        mv.getModel().put("menu",findmenu);
        mv.getModel().put("page",findallbypage);
        mv.getModel().put("citycode",code);
        for (NewHouseinfoEntity h:content) {
            System.out.println(h.getImgEntity().get(0).toString());
        }
        mv.setViewName("houseList");
        return mv;
    }


    /**
     * get old house info by paging
     * @param mv
     * @param page
     * @param citycode
     * @return
     */
    @Autowired
    private OldHourseInfoServise oldHourseInfoServise;
    @RequestMapping("/huantai.oldhouseinfo")
    public ModelAndView  getoldhousepage(ModelAndView mv,int page,String citycode){
        int size=5;
        String code=citycode;
        @NonNull
        Page<OldhouseinfoEntity> findallbypage = oldHourseInfoServise.findallbypage(page, size,citycode);
        List<MenuDTO> findmenu = menuService.findmenu();//get all title menu
        List<OldhouseinfoEntity> content = findallbypage.getContent();
        List<OldhouseinfoDTO> collect = content.stream().map(houseinfoEntity -> (OldhouseinfoDTO) new OldhouseinfoDTO().convertFrom(houseinfoEntity)).collect(Collectors.toList());
        mv.getModel().put("menu",findmenu);
        mv.getModel().put("page",findallbypage);
        mv.getModel().put("citycode",code);
        mv.getModel().put("houseinfo",collect);
        mv.setViewName("oldhouselist");
        return mv;
    }

    /**
     * get renting house info by paging
     * @param mv
     * @param page
     * @param citycode
     * @return
     */
    @Autowired
    private RentingHouseInfoService rentingHouseInfoService;
    @RequestMapping("/huantai.rentinghouseinfo")
    public ModelAndView  getrentinghousepage(ModelAndView mv,int page,String citycode){
        int size=5;
        @NonNull
        Page<RentinghouseinfoEntity> findallbypage = rentingHouseInfoService.findallbypage(page, size,citycode);
        List<MenuDTO> findmenu = menuService.findmenu();//get all title menu
        List<RentinghouseinfoEntity> content = findallbypage.getContent();
        List<RentingHouseInfoDTO> collect = content.stream().map(rentinghouseinfoEntity ->(RentingHouseInfoDTO) new RentingHouseInfoDTO().convertFrom(rentinghouseinfoEntity)).collect(Collectors.toList());
        mv.getModel().put("menu",findmenu);
        mv.getModel().put("page",findallbypage);
        mv.getModel().put("houseinfo",collect);
        mv.setViewName("rentinghouselist");
        return mv;
    }


    @RequestMapping("/huantai")
    public ModelAndView mainpage(ModelAndView mv){

        mv.setViewName("houseList");
         return mv;
    }


    @RequestMapping("/house.add")
    public void hourseadd(String buildinghead,String area,String decorated,String price,
                          String downpayment,String floor,String headline,String userid,String id,
                          String houseencoding,String houseid,String housetype,String recommend,
               String imgurl, String unitprice  ,String locationid,String imgid,String monthlypay){
    NewHouseinfoEntity newHouseinfoEntity =new NewHouseinfoEntity();
        newHouseinfoEntity.setBuildingtime(new Date(2012,2,3));
        newHouseinfoEntity.setBuildinghead(buildinghead);
        newHouseinfoEntity.setArea(area);
        newHouseinfoEntity.setDecorated(decorated);
        newHouseinfoEntity.setDownpayment(downpayment);
        newHouseinfoEntity.setFloor(floor);
        newHouseinfoEntity.setHeadline(headline);
        newHouseinfoEntity.setHouseencoding(houseencoding);
        newHouseinfoEntity.setHousetype(housetype);
        newHouseinfoEntity.setLocationid(locationid);
        newHouseinfoEntity.setMonthlypay(monthlypay);
        newHouseinfoEntity.setPrice(Integer.valueOf(price));

        NewHouseEntity newHouseEntity =new NewHouseEntity();
        newHouseEntity.setState("1");
        newHouseEntity.setRecommend(Integer.valueOf(recommend));


        Optional<UserinfoEntity> userinfoEntity = userInfoRepository.findById(Integer.valueOf(id));


        NewImgEntity imgEntity=new NewImgEntity();

        Set<NewImgEntity> imgEntities=new IdentitySet();
        imgEntities.add(imgEntity);

        newHouseEntity.setNewHouseinfoEntity(newHouseinfoEntity);
        userinfoEntity.get().addHouse(newHouseEntity);
        newHouseinfoEntity.setNewHouseEntity(newHouseEntity);
       // newHouseinfoEntity.setImgEntity(imgEntities);

        houseRepository.save(newHouseEntity);

    }
}
