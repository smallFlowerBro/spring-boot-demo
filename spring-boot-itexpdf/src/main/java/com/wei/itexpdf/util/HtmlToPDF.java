package com.wei.itexpdf.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.*;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.wei.itexpdf.util.img.MyImageProcessor;

import java.io.*;

/**
 * @Author weiyongjian
 * @Description //Html 生成pdf
 * @Date
 */
public class HtmlToPDF extends  PDFBuilder {

    @Override
    public String creatPDF(String msg) {
        ByteArrayInputStream byteArrayInputStream=null;
        String html=  reEscapeHtml(msg);
        String fileName = this.createFileName();
        Document in_doc= null;
        File file  =  new File("E:"+File.separator+fileName+".pdf");
        //声明字体
        MyFontProvider myFontProvider =new MyFontProvider();
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            in_doc=new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(in_doc,new FileOutputStream(file));
            in_doc.open();

            CssAppliers cssAppliers =new CssAppliersImpl(myFontProvider);
            HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(cssAppliers);
            DefaultTagProcessorFactory tpf=(DefaultTagProcessorFactory)Tags.getHtmlTagProcessorFactory();
            tpf.removeProcessor(HTML.Tag.IMG);
            tpf.addProcessor(new MyImageProcessor(),HTML.Tag.IMG);
            htmlPipelineContext.setTagFactory(tpf);
            CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
            Pipeline<?> pipeline = new CssResolverPipeline(cssResolver,new HtmlPipeline(htmlPipelineContext, new PdfWriterPipeline(in_doc,pdfWriter)));
            XMLWorker worker = new XMLWorker(pipeline,true);
            XMLParser xmlParser = new XMLParser(worker);
            byteArrayInputStream= new ByteArrayInputStream(html.getBytes());
            xmlParser.parse(new InputStreamReader(byteArrayInputStream));
            xmlParser.flush();
            if(byteArrayInputStream!=null){
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(byteArrayInputStream!=null){
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            in_doc.close();
            //添加水印
            addMark(fileName,"WeiYongjian",180,500);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO 后期可返回数据
        return "hahas";
    }
    public  String reEscapeHtml(String result) {
        String temp = result;
        //匹配script整个标签的正则
        final String scriptRegx = "(?i)(<SCRIPT)[\\s\\S]*?((</SCRIPT>)|(/>))";
        //匹配换行的正则
        final String brRegx = "(?i)(</*br.*?>)";
        //空格
        final String nbspRegx = "(&|&amp;)nbsp;";
        //table
        //final String tableRegx = "(?i)(<table (?!ignore=\"true\").*?>)";
        //img
        final String imgRegx = "(?i)(<img\\s.*?>)";
        temp = temp.replaceAll(scriptRegx, "")
                .replaceAll("\r|\n|\\r|\\n|\r\n|\\r\\n|\t|\\t", "")
                //.replaceAll(imgRegx, "")
                .replaceAll(brRegx, "<br />")
                .replaceAll(nbspRegx, " ")
                .replaceAll(" ", " ")
              //  .replaceAll(tableRegx, "<table class=\"cm_tb\" style=\"width:100%;table-layout:fixed; word-break:break-strict;\">")
        ;

        return temp;
    }

    /**
     * 添加 水印
     * @param srcFile
     */
    private void addMark(String srcFile,String text,int textWidth, int textHeight){
        try {
            String targetFile= "E:"+File.separator+srcFile+"_mark.pdf";
            File  file  =new File(targetFile);
            if(!file.exists()){
                file.createNewFile();
            }
            //添加水印得的文件
            PdfReader reader = new PdfReader("E:"+File.separator+srcFile+".pdf");
            //加完水印的文件
            PdfStamper pdfStamper = new PdfStamper(reader,new FileOutputStream(targetFile));
            // 设置字体
            BaseFont font = BaseFont.createFont("C:/WINDOWS/Fonts/SIMYOU.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
            //
            int total = reader.getNumberOfPages()+1;
            PdfContentByte content;
            //循环加入水印
            for (int i=1;i<total;i++){
                 content = pdfStamper.getUnderContent(i);
                 // 开始
                 content.beginText();
                 // 设置颜色 默认为蓝色
                 content.setColorFill(BaseColor.GRAY);
                 // content.setColorFill(Color.GRAY);
                 // 设置字体及字号
                 content.setFontAndSize(font, 70);
                 // 设置起始位置
                 // content.setTextMatrix(400, 880);
                 content.setTextMatrix(textWidth, textHeight);
                  // 开始写入水印
                 content.showTextAligned(Element.ALIGN_LEFT, text, textWidth,textHeight, 45);
                 content.endText();
            }
            pdfStamper.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
