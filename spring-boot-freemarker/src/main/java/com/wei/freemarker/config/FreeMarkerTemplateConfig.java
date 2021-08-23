package com.wei.freemarker.config;

import freemarker.cache.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Configuration
public class FreeMarkerTemplateConfig {
    @Value("${spring.freemarker.template.json}")
    private  String JSON_PATH;
    @Value("${spring.freemarker.template.xml}")
    private  String XML_PATH;

    @Bean(name = "JSONTemplateLoader")
    public ClassTemplateLoader jsonFreemarker(){
        freemarker.template.Configuration configuration =
                new freemarker.template.Configuration(freemarker.template.Configuration.getVersion());
        TemplateLoader templateLoader = new ClassTemplateLoader(getClass().getClassLoader(),JSON_PATH);
        return (ClassTemplateLoader) templateLoader;
    }
    @Bean(name = "JSONTemplateConfiguration")
    public freemarker.template.Configuration jsonTemplateConfiguration(
            @Qualifier("JSONTemplateLoader") ClassTemplateLoader classTemplateLoader ){
        freemarker.template.Configuration configuration = new freemarker.template.Configuration();
        configuration.setTemplateLoader(classTemplateLoader);
        return configuration;
    }
    @Bean(name = "XMLTemplateLoader")
    public ClassTemplateLoader xmlFreemarker(){
        freemarker.template.Configuration configuration =
                new freemarker.template.Configuration(freemarker.template.Configuration.getVersion());
        TemplateLoader templateLoader = new ClassTemplateLoader(getClass().getClassLoader(),XML_PATH);
        return (ClassTemplateLoader) templateLoader;
    }
    @Bean(name = "XMLTemplateConfiguration")
    public freemarker.template.Configuration xmlTemplateConfiguration(
            @Qualifier("XMLTemplateLoader") ClassTemplateLoader classTemplateLoader ){
        freemarker.template.Configuration configuration = new freemarker.template.Configuration();
        configuration.setTemplateLoader(classTemplateLoader);
        return configuration;
    }


}
