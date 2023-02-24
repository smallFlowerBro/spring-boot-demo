package com.wei.itexpdf.controller;

import com.wei.itexpdf.common.Response;
import com.wei.itexpdf.util.HtmlToPDF;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping("/pdf")
public class PDFController {
    /**
     * html 生成pdf 接口
     * @return
     */
    @PostMapping(value = "/htmlToPDF")
    public Map htmlToPDF(@RequestParam(value = "htmlMsg") String html){
        HtmlToPDF htmlToPDF= new HtmlToPDF();
        htmlToPDF.creatPDF(html);
        return Response.createSuccessResponse();
    }
}
