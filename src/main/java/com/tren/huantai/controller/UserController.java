package com.tren.huantai.controller;

import com.alibaba.fastjson.JSONObject;
import com.tren.huantai.model.entity.UserEntity;
import com.tren.huantai.model.entity.UserinfoEntity;
import com.tren.huantai.service.base.UserInfoService;
import com.tren.huantai.service.base.UserService;
import com.tren.huantai.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
@Slf4j
@RestController
public class UserController  {
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;
    @RequestMapping("/user.add")
    public void  adduser(ModelAndView mv, @Param("nickname") String nickname,@Param("pwd") String password,  @Param("birthday") String birthday,  @Param("sex")String sex,  @Param("mobilenumber")String mobilenumber, @Param("phonenumber")String phonenumber,@Param("name")String name){

       // userService.userregister(userEntity);
    }

    /**
     * user register
     * @param mv
     *
     * @return
     */
    @RequestMapping("/user/register")
    public ModelAndView userregister(ModelAndView mv){
     mv.setViewName("register");
        return mv;
    }
    @Autowired
  private  RedisUtil redisUtil;

    /**
     * verify email code
     * @param emailcode
     */
    @PostMapping("/user/register/verify")
    public String verifycode(String emailcode,String email){
        //Assert.notNull(emailcode,"emailcode must be not null");
        JSONObject jsonObject=new JSONObject();
        String code = redisUtil.get(email).toString();
         jsonObject.put("result", code.equals(emailcode));
          log.info("service email code:"+code);
          log.info("user email code:"+emailcode);
        return jsonObject.toString();
    }
}
