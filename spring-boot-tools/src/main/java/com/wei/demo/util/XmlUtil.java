package com.wei.demo.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class XmlUtil {
    public static Map<String,Object> xml2Map(String xml_str){
        //TODO
        Document document = null;
        HashMap<String, Object> map = new HashMap<>();
        try {
            document = DocumentHelper.parseText(xml_str);
            document.getRootElement().getText();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        String xml="<root><head>head</head><body>body</body></root>";
        Map<String, Object> map = XmlUtil.xml2Map(xml);
        System.out.println(map);

    }

}
