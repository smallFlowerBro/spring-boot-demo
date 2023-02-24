package com.wei.itexpdf.util;

/**
 * @Author weiyongjian
 * @Description //PDF 生成工具
 * @Date
 */
public abstract class PDFBuilder {
    public abstract String creatPDF(String html);

    protected  String createFileName(){
        return "file"+(int)(Math.floor(Math.random()*1000000));
    }
}
