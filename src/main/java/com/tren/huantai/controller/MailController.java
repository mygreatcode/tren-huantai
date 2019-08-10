package com.tren.huantai.controller;

import com.tren.huantai.model.params.Subject;
import com.tren.huantai.model.support.BaseResponse;
import com.tren.huantai.service.base.MailService;
import com.tren.huantai.utils.MailContentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Mail controller.
 *
 * @author tren
 * @date 19-5-7
 */
@RestController

public class MailController {
@Autowired
    MailContentUtils mailContentUtils;

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/user/mails/registercode")
    public BaseResponse sendVerificationCodeByMail(@Param("to") String to) {

        mailService.sendMail(to, Subject.REGISTER,mailContentUtils.RegisterContent(to));

        return BaseResponse.ok("发送成功");
    }


}
