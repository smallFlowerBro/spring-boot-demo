package com.wei.itexpdf.util;

import com.itextpdf.text.Font;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class MyFontProvider extends XMLWorkerFontProvider {
    public MyFontProvider() {
        super(null,null);
    }
    @Override
    public Font getFont(final String fontname, String encoding, float size, final int style) {
        String fntname = fontname;
        if (fntname == null) {
            fntname = "宋体";
        }
        if (size == 0) {
            size = 4;
        }
        return super.getFont(fntname, encoding, size, style);
    }
}

