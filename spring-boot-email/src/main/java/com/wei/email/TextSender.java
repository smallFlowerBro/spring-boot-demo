package com.wei.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Component
public class TextSender extends  BaseSender {

    public boolean send(String from,String subject,String text,String... to){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        try{
            mailSender.send(simpleMailMessage);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean send(String from,String subject,String text,String to){
        return send(from, subject, text, new String[]{to});
    }

    public boolean send(String subject,String text,String to){
        return send(emailConfig.getUsername(), subject, text, new String[]{to});
    }

    public boolean send(String subject,String text,String... to){
        return send(emailConfig.getUsername(), subject, text, to);
    }

}
