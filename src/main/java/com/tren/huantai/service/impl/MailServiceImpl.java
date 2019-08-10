package com.tren.huantai.service.impl;

import cn.hutool.core.text.StrBuilder;
import com.tren.huantai.exception.EmailException;
import com.tren.huantai.service.base.MailService;
import io.github.biezhi.ome.OhMyEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.Map;
import java.util.Properties;

/**
 * Mail service implementation.
 *
 * @author ryanwang
 * @date : 2019-03-17
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {



    /**
     * Sends a simple email
     *
     * @param to      recipient
     * @param subject subject
     * @param content content
     */
    @Override
    public void sendMail(String to, String subject, String content) {
        loadConfig();

        String fromUsername = "环太房产信息服务有限公司";

        try {
            OhMyEmail.subject(subject)
                    .from(fromUsername)
                    .to(to)
                    .text(content)
                    .send();
        } catch (Exception e) {
            log.debug("Email properties: to username: [{}], from username: [{}], subject: [{}], content: [{}]",
                    to, fromUsername, subject, content);

        }
    }

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * Sends template mail
     *
     * @param to           recipient
     * @param subject      subject
     * @param content      content
     * @param templateName template name
     */
    @Override
    public void sendTemplateMail(String to, String subject, Map<String, Object> content, String templateName) {
        loadConfig();

        String fromUsername = "";

        try {
            StrBuilder text = new StrBuilder();
            //Template template = freeMarker.getConfiguration().getTemplate(templateName);
            Context context=new Context();
            context.setVariable("text",content);
            text.append(templateEngine.process("template", context));
            OhMyEmail.subject(subject)
                    .from(fromUsername)
                    .to(to)
                    .html(text.toString())
                    .send();
        } catch (Exception e) {
            log.debug("Email properties: to username: [{}], from username: [{}], subject: [{}], template name: [{}], content: [{}]",
                    to, fromUsername, subject, templateName, content);
       throw new EmailException("Failed to send template email to " + to, e).setErrorData(templateName);
        }
    }

    /**
     * Sends mail with attachments
     *
     * @param to             recipient
     * @param subject        subject
     * @param content        content
     * @param templateName   template name
     * @param attachFilename attachment path
     */
    @Override
    public void sendAttachMail(String to, String subject, Map<String, Object> content, String templateName, String attachFilename) {
        loadConfig();

        String fromUsername = "optionService.getByPropertyOfNonNull(EmailProperties.FROM_NAME).toString()";

        File file = new File(attachFilename);

        try {
           // Template template = freeMarker.getConfiguration().getTemplate(templateName);
            Context context=new Context();
            context.setVariable("text",content);
            OhMyEmail.subject(subject)
                    .from(fromUsername)
                    .to(to)
                    .html(templateEngine.process("template", context))
                    .attach(file, file.getName())
                    .send();
        } catch (Exception e) {
            log.debug("Email properties: to username: [{}], from username: [{}], subject: [{}], template name: [{}], attachment: [{}], content: [{}]",
                    to, fromUsername, subject, templateName, attachFilename, content);
            throw new EmailException("Failed to send attachment email to " + to, e);
        }
    }
    @Autowired
    Environment ev ;
    /**
     * Loads email config.
     */
    private void loadConfig() {

        Properties defaultProperties = OhMyEmail.defaultConfig(true);

        // Set smtp host
        defaultProperties.put("mail.smtp.starttls.enable", "true");
        defaultProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        defaultProperties.setProperty("mail.host",  "smtp.qq.com");
        // Config email
        OhMyEmail.config(defaultProperties, "599821922@qq.com", "ilvhubtlheglbcgj");



    }

}
