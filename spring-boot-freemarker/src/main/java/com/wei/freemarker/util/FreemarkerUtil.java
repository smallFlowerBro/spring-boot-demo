package com.wei.freemarker.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service
public class FreemarkerUtil {
    @Autowired
    @Qualifier("JSONTemplateConfiguration")
    private Configuration jsonConfiguration;

    @Autowired
    @Qualifier("XMLTemplateConfiguration")
    private Configuration xmlConfiguration;

    @Value("${spring.freemarker.template.json}")
    public String JSON_PATH;
    @Value("${spring.freemarker.template.xml}")
    public String XML_PATH;

    public String process(String fileName, Map dataMap){
        String str="";
        if(fileName == null||"".equals(fileName)){
            System.out.println("模板名不得为空");
            return "";
        }
        Template template=null;
        String t_fileName = fileName.toLowerCase();
        try {
            //json文件
            if(fileName.indexOf(".json")!=-1){
                template = jsonConfiguration.getTemplate(getAbsolutePath(fileName));
            }else if(fileName.indexOf(".xml")!=-1){
                //xml文件
                template = xmlConfiguration.getTemplate(getAbsolutePath(fileName));
            }else{
                System.out.println("模板文件格式有误");
            }
            str = FreeMarkerTemplateUtils.processTemplateIntoString(template,dataMap);
        } catch (IOException e) {
            e.printStackTrace();

        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return str;
    }

    private String getAbsolutePath(String fileName) {
        File file=null;
        if(fileName.indexOf(".json")!=-1){
            file =new File((Thread.currentThread().getContextClassLoader().getResource("").
                    getPath()+JSON_PATH+fileName).replaceAll("//","/"));
        }else if(fileName.indexOf(".xml")!=-1){
            file =new File((Thread.currentThread().getContextClassLoader().getResource("").
                    getPath()+XML_PATH+fileName).replaceAll("//","/"));
        }

        return file.getName();
    }
}
