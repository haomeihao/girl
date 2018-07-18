package com.imooc.girl.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import org.thymeleaf.TemplateEngine;

/**
 * Created by hmh on 2017/11/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private MailServiceImpl mailService;

    @Autowired
//    private TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail("2305863389@qq.com","test mail", "hello java mail sender");
    }

    @Test
    public void sendHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
//        mailService.sendHtmlMail("2305863389@qq.com","test mail html",content);
    }

}