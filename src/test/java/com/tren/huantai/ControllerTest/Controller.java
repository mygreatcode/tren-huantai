package com.tren.huantai.ControllerTest;

import com.tren.huantai.servicetest.ServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
public class Controller {
    @Autowired
    private ServiceTest serviceTest;
    @Test
    @RequestMapping("/info")
    public void test(){
        System.out.println("测试");
    }
}
