package com.tren.huantai.controller;

import lombok.extern.slf4j.Slf4j;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Slf4j
@RestController
public class ChangeCityController {
    @RequestMapping("/changecity.com")
    public ModelAndView change(ModelAndView mv,String city,String citycode){
        Map<String, Object> model = mv.getModel();
        model.put("city",city);
        model.put("citycode",citycode);
        mv.setViewName("demo");
        return mv;
    }
}
