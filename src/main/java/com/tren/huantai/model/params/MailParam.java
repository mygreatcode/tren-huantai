package com.tren.huantai.model.params;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class MailParam {

    @NotBlank(message = "收件人不能为空")
    private String to;

    @NotBlank(message = "主题不能为空")
    private String subject;

    @NotBlank(message = "内容不能为空")
    private String content;

}
