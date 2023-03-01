package com.wei.demo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * @Author weiyongjian
 * @Description 复杂邮件发送
 * @Date
 */
@Component
public class MimeSender extends  BaseSender {

    public boolean send(String from,
                     String[] to,
                     String subject,
                     String text,
                     List<String> inlineFile,
                     List<String> attachFile
    ){
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);
            if(inlineFile!=null){
                for (String s : inlineFile) {
                    File file = new File(s);
                    mimeMessageHelper.addInline(file.getName(),file);
                }
            }
            if (attachFile!=null) {
                for (String s : attachFile){
                    File file = new File(s);
                    mimeMessageHelper.addAttachment(file.getName(),file);
                }
            }
            mailSender.send(mimeMessage);
            return true;
        }catch ( MessagingException e){
            return false;
        }
    }
    public boolean send(
            String from,
            String to,
            String subject,
            String text,
            List<String> inlineFile,
            List<String> attachFile
    ){
        return  send(from,new String[]{to},subject,text,inlineFile,attachFile);
    }
    public boolean send(
                     String[] to,
                     String subject,
                     String text,
                     List<String> inlineFile,
                     List<String> attachFile
    ) {
        return  send(emailConfig.getUsername(),to,subject,text,inlineFile,attachFile);
    }
    public boolean send(
            String to,
            String subject,
            String text,
            List<String> inlineFile,
            List<String> attachFile
    ){
        return  send(emailConfig.getUsername(),to,subject,text,inlineFile,attachFile);
    }
    public boolean send(
            String to,
            String subject,
            String text
    ) {
        return  send(emailConfig.getUsername(),to,subject,text,null,null);
    }
    public boolean send(
            String[] to,
            String subject,
            String text,
            List<String> attachFile
    ){
        return  send(emailConfig.getUsername(),to,subject,text,null,attachFile);
    }

}
