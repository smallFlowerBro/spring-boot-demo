package com.wei.demo;

import com.wei.demo.config.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class BaseSender {
    @Autowired
    protected EmailConfig emailConfig;
    @Autowired
    protected JavaMailSender mailSender;

}
