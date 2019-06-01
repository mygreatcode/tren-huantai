package com.tren.huantai.controller;

import com.tren.huantai.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
   private AdminService adminService;

}
