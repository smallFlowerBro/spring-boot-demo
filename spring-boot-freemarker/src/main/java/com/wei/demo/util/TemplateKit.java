package com.wei.demo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import java.io.IOException;
import java.util.Map;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Component
public class TemplateKit {
    private Configuration configuration;

    @PostConstruct
    private void start(){
        configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setClassicCompatible(true);
        configuration.setClassForTemplateLoading(this.getClass(),"/com/wei/demo/template/");
    }

    /**
     * 合成模板
     * @param url
     * @param map
     * @return
     */
    public String process(String url, Map map){
        String s=null;
        try {
            Template template = configuration.getTemplate(url);
            s = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return s;
    }

}
