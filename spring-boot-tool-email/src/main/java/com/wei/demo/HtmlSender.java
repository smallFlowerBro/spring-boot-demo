package com.wei.demo;

import com.wei.demo.util.TemplateKit;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Component
public class HtmlSender extends BaseSender {

    @Autowired
    private TemplateKit templateKit;

    public boolean send(Map<String,String> parms,
                        String templata_name,
                        String from,
                        String[] to,
                        String subject,
                        Map<String, Resource> inlineFile,
                        Map<String, File> attachFile){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {

            String html = templateKit.process(templata_name, parms);
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(html,true);
            mailSender.send(mimeMessage);
            if(inlineFile!=null&&inlineFile.size()>0){
                Set<String> strings = inlineFile.keySet();
                for (String string : strings) {
                    System.out.println(string);
                    mimeMessageHelper.addInline(string,inlineFile.get(string));
                }
            }
            if(attachFile!=null&&attachFile.size()>0){
                Set<String> strings = attachFile.keySet();
                for (String string : strings) {
                    System.out.println(string);
                    mimeMessageHelper.addAttachment(string,attachFile.get(string));
                }
            }
            return true;
        } catch ( MessagingException e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean send(Map<String,String> parms,
                        String templata_name,
                        String[] to,
                        String subject,
                        Map<String, Resource> inlineFile,
                        Map<String, File> attachFile){
        return send(parms,templata_name,emailConfig.getUsername(),to,subject,inlineFile,attachFile);

    }
    public boolean send(Map<String,String> parms,
                        String templata_name,
                        String[] to,
                        String subject){
        return  send(parms,templata_name,emailConfig.getUsername(),to,subject,null,null);
    }
}
