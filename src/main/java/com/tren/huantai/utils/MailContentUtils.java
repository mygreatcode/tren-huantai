package com.tren.huantai.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class MailContentUtils {

@Autowired
private RedisUtil redisUtil;
    public   String RegisterContent(String to){

        return "<p>尊敬的环太房产用户：</p><p>您好!</p><p>您正在注册环太房产信息服务中心账号！您的验证码是："+getcode(to)+"</p><p>请妥善保管您的账号和密码。</p><p>有效时间为30分钟</p><p>您的光临是我们的荣幸，感谢！</p>";

    }

    public String getcode(String to){
       String code= String.valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
        redisUtil.set( to,code,1000*30);//验证码存入Redis缓存,以邮箱账号作为key
        return  code;
    }

}
