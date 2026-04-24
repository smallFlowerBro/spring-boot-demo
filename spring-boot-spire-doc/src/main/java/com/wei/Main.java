package com.wei;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.PageBordersApplyType;
import com.spire.doc.documents.BorderStyle;
import com.spire.doc.documents.MarginsF;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.XHTMLValidationType;
import com.spire.doc.formatting.ParagraphFormat;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.PdfImage;
import com.spire.pdf.graphics.PdfTilingBrush;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main {

    public static ByteArrayOutputStream conformHtmlToPdf(String str){
        Document document = new Document();
        document.loadFromStream(new ByteArrayInputStream(str.getBytes()),FileFormat.Html, XHTMLValidationType.None);
        for (int i =0;i<document.getSections().getCount();i++){

            document.getSections().get(i).getPageSetup().setPageBordersApplyType(PageBordersApplyType.All_Pages);
            // 设置边框样式
            document.getSections().get(i).getPageSetup().getBorders().setBorderType(BorderStyle.None);

            // 设置边框宽度
            document.getSections().get(i).getPageSetup().getBorders().setLineWidth(1);

            // 设置边框颜色
            document.getSections().get(i).getPageSetup().getBorders().setColor(new Color(255, 255, 255,0));

            MarginsF margins = document.getSections().get(i).getPageSetup().getMargins();
            margins.setTop(margins.getTop()/2);
            margins.setBottom(margins.getBottom()/2);
            margins.setLeft(margins.getLeft()/2);
            margins.setRight(margins.getRight()/2);


            for (int j = 0;j<document.getSections().get(i).getParagraphs().getCount();j++){
                Paragraph paragraph = document.getSections().get(i).getParagraphs().get(j);
                ParagraphFormat format = paragraph.getFormat();
                format.setLineSpacing(10f);
//                for (int m =0;m<paragraph.getChildObjects().getCount();m++){
//                    DocumentObject documentObject = paragraph.getChildObjects().get(m);
//                    if(documentObject instanceof DocPicture){
//                        DocPicture documentObject1 = (DocPicture) documentObject;
//                        try(ByteArrayInputStream bis= new ByteArrayInputStream(documentObject1.getImageBytes())){
//                            BufferedImage img = ImageIO.read(bis);
//                            documentObject1.setWidth(50);
//                            documentObject1.setHeight(15);
//
//                        } catch (Exception e){
//                            e.printStackTrace();
//                        }
//
//
//                    }
//
//
//                }
            }

        }

        // 将 HTML 文件保存为 PDF
        //document.saveToFile("C:/Users/Administrator/Desktop/HTML转PDF.pdf", FileFormat.PDF);
        //保存输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.saveToStream(byteArrayOutputStream,FileFormat.PDF);
        document.dispose();
        return byteArrayOutputStream;
    }
    // 压缩图片
    public static BufferedImage compressImage(BufferedImage originalImage, float quality) {
        int newWidth = (int)(originalImage.getWidth() * quality);
        int newHeight = (int)(originalImage.getHeight() * quality);

        BufferedImage compressedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = compressedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();

        return compressedImage;
    }

    // 按比例缩放图片
    public static BufferedImage scaleImage(BufferedImage originalImage, float maxWidth, float maxHeight) {
        float ratio = Math.min(maxWidth / originalImage.getWidth(), maxHeight / originalImage.getHeight());
        int newWidth = (int)(originalImage.getWidth() * ratio);
        int newHeight = (int)(originalImage.getHeight() * ratio);

        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();

        return scaledImage;
    }


    public static void addMark(InputStream inputStream) throws IOException {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromStream(inputStream);
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            PdfPageBase page = pdf.getPages().get(i);

            Dimension2D dimension2D = new Dimension();
            dimension2D.setSize(page.getCanvas().getSize().getWidth()/4, page.getCanvas().getSize().getHeight()/3);

            PdfTilingBrush brush = new PdfTilingBrush(dimension2D);
            brush.getGraphics().setTransparency(0.2f);
            //brush.getGraphics().translateTransform(brush.getSize().getWidth()/10,brush.getSize().getHeight()/10);
            //brush.getGraphics().rotateTransform(30);

            BufferedImage originalImage = ImageIO.read(new File("logo.png"));
            BufferedImage optimizedImage = scaleImage(originalImage, 300, 300); // 限制最大宽高为500px
            PdfImage image = PdfImage.fromImage(optimizedImage);
            brush.getGraphics().drawImage(image,brush.getSize().getWidth()-image.getWidth()/2,(brush.getSize().getHeight())/2);

            Rectangle2D rectangle2D = new Rectangle2D.Float();
            rectangle2D.setFrame(new Point(0,0),page.getCanvas().getClientSize());

            page.getCanvas().drawRectangle(brush,rectangle2D);


        }
        //保存文档
        pdf.saveToFile("C:/Users/Administrator/Desktop/HTML转PDF.pdf");
        pdf.dispose();

    }

    public static void main(String[] args) {

        String str ="<!DOCTYPE html><html><head><meta  charset=\"utf-8\" /><title >电子病历</title><style>p{font-family:宋体;margin:0px;font-family:宋体;font-size:12pt;lineSpace:1.5;fontSpace:0;}.page-content table tr{height:40px;}.page-style{padding: 1cm;margin: 0 auto;border: 1px #D3D3D3 solid;border-radius: 5px;background: white;box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);margin-bottom: 5px;}.page-content table tr td,.page-content table,.page-header table,.page-header table tr td {border: 0.8px solid #000;}.page-content table,.page-header table {border-spacing: 0;}header table td p{text-indent: 0px !important;}.page-size{width:210.000000mm;min-height:297.000000mm;}.article-size{min-height:277mm;}</style></head><body style=\"margin:0\"><div class=\"page-size page-style\"><div class=\"article-size\"><header><p style=\"text-align:left;display:block;\"><span style=\"\"></span><span style=\"\"></span><span style=\"\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span></p><table style=\"width:100%;border-spacing:0px;border-collapse: collapse;border-left-color:#000000;border-bottom-style:none;border-right-color:#000000;border-top-color:#000000;border-top-style:none;border-bottom-color:#000000;border-right-style:none;border-left-style:none;\"><colgroup><col style='width:3.00cm;'><col style='width:3.25cm;'><col style='width:3.87cm;'><col style='width:2.87cm;'><col style='width:3.37cm;'></colgroup><tr style=\"height:1.37cm;\" ><td colspan=5  rowspan=1 style=\"border:1px solid #000;width:16.36cm;border:0.8px solid #000;border-style:solid;border-top-style:none;border-bottom-style:none;border-right-style:none;border-left-style:none;border-left-color:#000000;border-bottom-style:none;border-right-color:#000000;border-top-color:#000000;border-left-style:none;border-bottom-color:#000000;border-right-style:none;border-top-style:none;\"><p style=\"text-align:center;display:block;\"><span style=\"font-family:宋体;font-size:24pt;\">南<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>华<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>大<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>学<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>附<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>属<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>第<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>二<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>医<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>院</span></p></td></tr><tr style=\"height:1.25cm;\" ><td colspan=5  rowspan=1 style=\"border:1px solid #000;width:16.36cm;border:0.8px solid #000;border-style:solid;border-top-style:none;border-bottom-style:none;border-right-style:none;border-left-style:none;border-left-color:#000000;border-bottom-style:none;border-right-color:#000000;border-top-color:#000000;border-left-style:none;border-bottom-color:#000000;border-right-style:none;border-top-style:none;\"><p style=\"text-align:center;display:block;\"><span style=\"font-size:22pt;\">病程记录</span></p></td></tr><tr style=\"height:0.75cm;\" ><td colspan=1  rowspan=1 style=\"border:1px solid #000;width:3.00cm;border:0.8px solid #000;border-style:solid;border-top-style:none;border-bottom-style:none;border-right-style:none;border-left-style:none;border-left-color:#000000;border-bottom-style:solid;border-right-color:#000000;border-top-color:#000000;border-left-style:none;border-bottom-color:#000000;border-right-style:none;border-top-style:none;\"><p style=\"text-align:left;display:block;\"><span style=\"font-family:宋体;font-size:12pt;\">姓名:</span><span style=\"font-size:12pt;font-family:宋体;\">封漠斌</span></p></td><td colspan=2  rowspan=1 style=\"border:1px solid #000;width:7.12cm;border:0.8px solid #000;border-style:solid;border-top-style:none;border-bottom-style:none;border-right-style:none;border-left-style:none;border-left-color:#000000;border-bottom-style:solid;border-right-color:#000000;border-top-color:#000000;border-top-style:none;border-left-style:none;border-right-style:none;border-bottom-color:#000000;\"><p style=\"display:block;\"><span style=\"font-size:12pt;\">科室:</span><span style=\"font-size:12pt;\">神经外科二区</span></p></td><td colspan=1  rowspan=1 style=\"border:1px solid #000;width:2.87cm;border:0.8px solid #000;border-style:solid;border-top-style:none;border-bottom-style:none;border-right-style:none;border-left-style:none;border-left-color:#000000;border-bottom-style:solid;border-right-color:#000000;border-top-color:#000000;border-left-style:none;border-bottom-color:#000000;border-right-style:none;border-top-style:none;\"><p style=\"display:block;\"><span style=\"font-family:宋体;font-size:12pt;\">床号:</span><span style=\"font-family:宋体;font-size:12pt;\">B28-048</span></p></td><td colspan=1  rowspan=1 style=\"border:1px solid #000;width:3.37cm;border:0.8px solid #000;border-style:solid;border-top-style:none;border-bottom-style:none;border-right-style:none;border-left-style:none;border-left-color:#000000;border-bottom-style:solid;border-right-color:#000000;border-top-color:#000000;border-left-style:none;border-bottom-color:#000000;border-right-style:none;border-top-style:none;\"><p style=\"text-align:left;text-indent:0.00cm;margin-left:0.00cm;display:block;\"><span style=\"\"></span><span style=\"font-family:宋体;font-size:12pt;\">病案号:</span><span style=\"\"></span><span style=\"font-size:12pt;font-family:宋体;\">60565400</span><span style=\"\"></span></p></td></tr></table><p style=\"text-align:left;line-height:1pt;display:block;\"><span style=\"\"></span>&nbsp;</p></header><section class=\"page-content\"><p style=\"text-align:center;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"font-size:12pt;font-family:宋体;font-weight:bold;\">首次病程记录</span></p><p style=\"text-align:left;line-height:1.5;display:block;\"><span style=\"font-size:12pt;font-family:宋体;font-weight:bold;\">2025年03月25日<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>13时04分</span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"font-weight:bold;display:inline;font-size:12pt;\">1.病例特点：</span></p><p style=\"text-align:left;line-height:1.5;font-size:12pt;display:block;\"><span style=\"display:inline;font-size:12pt;\">患者姓名：</span><span style=\"\"></span><span style=\"font-size:12pt;\">封漠斌</span><span style=\"font-size:12pt;\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"\"></span><span style=\"\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"display:inline;font-size:12pt;\">性别：</span><span style=\"\"></span><span style=\"display:inline;font-size:12pt;\">男</span><span style=\"display:inline;font-size:12pt;\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"\"></span><span style=\"\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"display:inline;font-size:12pt;\">年龄：</span><span style=\"\"></span><span style=\"font-size:12pt;display:inline;\">52岁</span><span style=\"display:inline;font-size:12pt;\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"\"></span><span style=\"\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"display:inline;font-size:12pt;\">病程：</span><span style=\"display:inline;font-size:12pt;\">16小时</span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;font-size:12pt;display:block;\"><span style=\"\"></span><span style=\"font-weight:bold;display:inline;font-size:12pt;\">临床表现：</span><span style=\"\"></span><span style=\"display:inline;font-size:12pt;display:none !important;\">头痛16小时余</span><span style=\"display:inline;font-size:12pt;display:inline;font-size:12pt;\">头痛16小时余。</span><span style=\"\"></span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;font-size:12pt;display:block;\"><span style=\"\"></span><span style=\"font-weight:bold;display:inline;font-size:12pt;\">既往史：</span><span style=\"\"></span><span style=\"display:inline;font-size:12pt;display:none !important;\">有“艾滋病”病史8年，规律服用洛匹那韦利托那韦片1片<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>bid+齐多拉米双夫定片1片<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>bid，有“慢性支气管炎并肺气肿”病史1年余，否认“糖尿病、冠心病、高血压”等慢性病史,否认有“肝炎、结核、伤寒”等传染病史，无手术、外伤、输血史，无药物及食物过敏史,预防接种史不详，无长期服用阿司匹林等药物史。</span><span style=\"display:inline;font-size:12pt;display:inline;font-size:12pt;\">有“艾滋病”病史8年，规律服用洛匹那韦利托那韦片1片<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>bid+齐多拉米双夫定片1片<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>bid；有“慢性支气管炎并肺气肿”病史1年余，否认“糖尿病、冠心病、高血压”等慢性病史,否认有“肝炎、结核、伤寒”等传染病史，无手术、外伤、输血史，无药物及食物过敏史,预防接种史不详，无长期服用阿司匹林等药物史。</span><span style=\"\"></span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;font-size:12pt;display:block;\"><span style=\"\"></span><span style=\"font-size:12pt;display:inline;font-weight:bold;\">体格检查：</span><span style=\"\">T：</span><span style=\"\"></span><span style=\"\">36.6</span><span style=\"\"></span><span style=\"\">℃,P：</span><span style=\"\"></span><span style=\"\">85</span><span style=\"\"></span><span style=\"\">次/分,R：</span><span style=\"\"></span><span style=\"\">19</span><span style=\"\"></span><span style=\"\">次/分,BP：</span><span style=\"\"></span><span style=\"\">135</span><span style=\"\"></span><span style=\"\">/</span><span style=\"\"></span><span style=\"\">75</span><span style=\"\"></span><span style=\"\">mmHg,</span><span style=\"\"></span><span style=\"display:none !important;\">神志模糊，呼唤睁眼，对答稍含糊，肢体刺痛定位，查体尚配合，GCS评分=E3V2M5=10分，枕部可见一约5cm*5cm大小的肿物，质软，活动度一般，双侧瞳孔等大等圆，直径2.0mm，瞳孔对光反射稍迟钝，双侧额纹对称，嘴角无歪斜，伸舌居中，咽反射灵敏，颈软，左侧肢体肌力5级，右侧肢体肌力4级，肌张力不高。深浅反射存在，无亢进，双侧巴氏征阴性。</span><span style=\"display:none !important;\">神志模糊，呼唤睁眼，对答稍含糊，肢体刺痛定位，查体尚配合，GCS评分=E3V2M5=10分，枕部可见一约5cm*5cm大小的肿物，质软，活动度一般，双侧瞳孔等大等圆，直径2.0mm，瞳孔对光反射稍迟钝，双侧额纹对称，嘴角无歪斜，伸舌居中，咽反射灵敏，颈软，肌力检查不配合，肌张力不高。深浅反射存在，无亢进，双侧巴氏征阴性。</span><span style=\"\">神志模糊，呼唤睁眼，对答不配合，言语混乱，四肢刺痛定位，GCS评分=E3V3M5=11分，枕部可见一约5cm*5cm大小的肿物，质软，活动度一般，双侧瞳孔等大等圆，直径2.0mm，瞳孔对光反射稍迟钝，嘴角无歪斜，伸舌不配合，咽反射灵敏，颈软，肌力检查不配合，肌张力不高。深浅反射存在，无亢进，双侧巴氏征阴性。</span><span style=\"\"></span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"font-size:12pt;display:inline;font-weight:bold;\">辅助检查：</span><span style=\"\"></span><span style=\"display:inline;font-size:12pt;\">2025-03-25，我院急诊头胸腹CT+头颈部CTA：1、左侧颞叶脑出血；2、左侧大脑中动脉M2动脉瘤；右侧颈内动脉C7动脉瘤可疑；头颈部动脉粥样硬化改变；3、脑白质疏松症；4、慢性支气管疾患并肺气肿、肺大疱，左肺下叶感染；5、主动脉及冠脉多发钙化灶；6、双肾小结石；7、前列腺钙化灶。</span><span style=\"\"></span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"font-weight:bold;display:inline;font-size:12pt;\">2.拟诊讨论：</span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"font-weight:bold;display:inline;font-size:12pt;\">诊断依据：</span><span style=\"display:inline;font-size:12pt;\">患者封漠斌，52岁男性，因“</span><span style=\"\">头痛16小时余</span><span style=\"display:inline;font-size:12pt;\">”入院，既往</span><span style=\"\">有“艾滋病”病史8年，规律服用洛匹那韦利托那韦片1片<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>bid+齐多拉米双夫定片1片<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>bid，有“慢性支气管炎并肺气肿”病史1年余；体查：</span><span style=\"\">神志模糊，呼唤睁眼，对答不配合，言语混乱，四肢刺痛定位，GCS评分=E3V3M5=11分，枕部可见一约5cm*5cm大小的肿物，质软，活动度一般，双侧瞳孔等大等圆，直径2.0mm，瞳孔对光反射稍迟钝，嘴角无歪斜，伸舌不配合，咽反射灵敏，颈软，肌力检查不配合，肌张力不高。深浅反射存在，无亢进，双侧巴氏征阴性。</span><span style=\"display:none !important;\">神志模糊，呼唤睁眼，对答稍含糊，肢体刺痛定位，查体尚配合，GCS评分=E3V2M5=10分，枕部可见一约5cm*5cm大小的肿物，质软，活动度一般，双侧瞳孔等大等圆，直径2.0mm，瞳孔对光反射稍迟钝，双侧额纹对称，嘴角无歪斜，伸舌居中，咽反射灵敏，颈软，肌力检查不配合，肌张力不高。深浅反射存在，无亢进，双侧巴氏征阴性。</span><span style=\"display:none !important;\">神志模糊，呼唤睁眼，对答稍含糊，肢体刺痛定位，查体尚配合，GCS评分=E3V2M5=10分，枕部可见一约5cm*5cm大小的肿物，质软，活动度一般，双侧瞳孔等大等圆，直径2.0mm，瞳孔对光反射稍迟钝，双侧额纹对称，嘴角无歪斜，伸舌居中，咽反射灵敏，颈软，左侧肢体肌力5级，右侧肢体肌力4级，肌张力不高。深浅反射存在，无亢进，双侧巴氏征阴性。</span><span style=\"\">辅助检查：2025-03-25，我院急诊头胸腹CT+头颈部CTA：1、左侧颞叶脑出血；2、左侧大脑中动脉M2动脉瘤；右侧颈内动脉C7动脉瘤可疑；头颈部动脉粥样硬化改变；3、脑白质疏松症；4、慢性支气管疾患并肺气肿、肺大疱，左肺下叶感染；5、主动脉及冠脉多发钙化灶；6、双肾小结石；7、前列腺钙化灶。</span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;text-align:left;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"font-size:12pt;display:inline;font-weight:bold;\">鉴别诊断：</span><span style=\"\"></span><span style=\"\">1.</span><span style=\"display:none !important;\">动脉瘤：多见于中老年患者，多有高血压，高血脂动脉硬化等。多位于<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>Willis</span><span style=\"display:none !important;\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"display:none !important;\">环附近。多表现为自发性蛛网膜下腔出血头痛</span><span style=\"display:none !important;\">。</span><span style=\"display:none !important;\">DSA</span><span style=\"display:none !important;\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"display:none !important;\">可明确</span><span style=\"display:none !important;\">。</span><span style=\"display:none !important;\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"\">烟雾病：为颈内动脉末端或大脑前动脉和中动脉起始部闭塞或狭窄，颅底血管代偿性增生呈烟雾状，可引起出血或缺血症状。可合并动脉瘤。<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span></p><p style=\"line-height:1.5;display:block;\"><span style=\"\">2.海绵状血管瘤：脑内主要表现为癫痫、头痛，出血，神经功能缺损，常见慢性反复少量出<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>血，急性大量出血少见。多表现为混杂近似球形信号，CT<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>常可见钙化，多为高密度，MRI<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>常可见<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>T2<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>像典型铁环征。DSA<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>一般不显影。该患者影像学支持。</span></p><p style=\"line-height:1.5;display:block;\"><span style=\"\">3.</span><span style=\"\">动静脉畸形：脑血管畸形是脑血管先天性、非肿瘤性发育异常。是指脑血管发育障碍而引起的脑局部血管数量和结构异常，并对正常脑血流产生影响。其破裂出血主要表现为脑内出血或血肿。其多见于年轻人，发病年龄平均20</span><span style=\"\">～</span><span style=\"\">40岁</span><span style=\"\">。</span><span style=\"\"></span><span style=\"\"></span></p><p style=\"text-align:left;text-indent:-2.12cm;line-height:1.5;margin-left:2.12cm;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"font-size:12pt;display:inline;font-weight:bold;\">入院诊断：</span><span style=\"\"></span><span style=\"display:inline;font-size:12pt;\">1.左侧颞叶脑出血，左侧大脑中动脉M2动脉瘤；2.艾滋病；3.慢性支气管疾患并肺气肿；肺大疱；肺部感染；4.头颈部动脉粥样硬化；5.双肾结石</span><span style=\"display:inline;font-size:12pt;display:none !important;\">1、左侧颞叶脑出血，左侧大脑中动脉M2动脉瘤；2、艾滋病；3、慢性支气管疾患并肺气肿、肺大疱，左肺下叶感染；4、头颈部动脉粥样硬化；5、双肾结石</span><span style=\"\"></span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"font-size:12pt;display:inline;font-weight:bold;\">3.病例分型：</span><span style=\"\"></span><span style=\"display:inline;font-size:12pt;\">D</span><span style=\"\"></span><span style=\"\">型</span><span style=\"\"></span></p><p style=\"text-align:left;line-height:1.5;text-align:left;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"font-weight:bold;display:inline;font-size:12pt;\">4.诊疗计划：</span><span style=\"display:inline;font-size:12pt;\">1）</span><span style=\"\">告病危，入ICU监护治疗</span><span style=\"display:inline;font-size:12pt;\">。</span></p><p style=\"text-align:left;line-height:1.5;text-align:left;line-height:1.5;display:block;\"><span style=\"display:inline;font-size:12pt;\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>2）完善三大常规、肝肾功能、心电图、头颅、胸部CT等检查。</span></p><p style=\"text-align:left;line-height:1.5;text-align:left;line-height:1.5;display:block;\"><span style=\"display:inline;font-size:12pt;\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>3）予护胃、营养支持、控制血压等对症治疗，后续动态复查头颅CT，不除外手术治疗；</span></p><p style=\"text-align:left;line-height:1.5;text-align:left;line-height:1.5;display:block;\"><span style=\"display:inline;font-size:12pt;\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span>4）患者入院VTE高危组，仍有颅内再出血风险，暂予以物理或机械预防血栓，动态复查D-二聚体，下肢静脉B超。<span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"\"></span></p><p style=\"text-align:right;line-height:1.5;display:block;\"><span style=\"\"></span><span style=\"\"></span><span style=\"\"></span><span style=\"font-size:12pt;font-family:宋体;\">住院医师：</span><img style=\"height:0.2000in;\" src=\"data:image/png;base64,\n" +
                "/9j/4AAQSkZJRgABAgEAAAAAAAD/2wBDAFA3PEY8MlBGQUZaVVBfeMiCeG5uePWvuZHI////\n" +
                "////////////////////////////////////////////////2wBDAVVaWnhpeOuCguv/////\n" +
                "////////////////////////////////////////////////////////////////////wAAR\n" +
                "CAEdAvYDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAA\n" +
                "AgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkK\n" +
                "FhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWG\n" +
                "h4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl\n" +
                "5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREA\n" +
                "AgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYk\n" +
                "NOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOE\n" +
                "hYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk\n" +
                "5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwC7RRRQAUUUUAFFFFABRRRQAUUUUAFFFFAB\n" +
                "RRRQAUUUUAFFFFABRUMtzHFkZ3MOwqo9zNMdsYI9l60AXnljj++4Ht3qtJfAEiNc+5qOOykb\n" +
                "lyE/U1YWzhUcgt9T/hQBSkuJJeGbA9BwKirRuUjjt2IRAeg4rOoA07ORpIctyQcZ9anqG0Xb\n" +
                "bpxyeamoAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoooo\n" +
                "AKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKz76IrL5n8LfzrQproJEKt0\n" +
                "NAGSjlHDL1BrVikEsYcd/wBKy5YzFIVbt0PrUtpN5cm1j8jfoaANKiiigAooooAKKKKACiii\n" +
                "gAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAK\n" +
                "KKKACiiigAoqOWZIh87c+neqjTzXBKxKQvqP8aALM1xHEDk5b+6KqmSe5yEGE6cdPz/z9Kmi\n" +
                "skXBkO4+nb/P+cVZAAGAMAUAVY7FBgyEsfQcCrSqFUKoAA7ClooAKKKbI4RGY9AM0AUr+TLC\n" +
                "MdByfrUNvH5syqenU/SmOxdyx6k5rRtIfKjyR8zcmgCeiiigAooooAKKKKACiiigAooooAKK\n" +
                "KKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACkJAGTwKrT3ip8seGPr2q\n" +
                "i8jSNudsmgDX69KWqOnudzR9sZq9QAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQBXu4BLHkD51\n" +
                "6e/tWbW1VG8t+TKg4/iH9aAHWdwCBE/UcKfX2q5WL06Vo2tyJRtbhx+tAFmiiigAooooAKKK\n" +
                "KACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigA\n" +
                "ooqrNeKnEeGb17UAWHdUXcxAHvVR7t5G2QL+P+en4/pSJbyztvmJA9O//wBarccaxrtQYFAF\n" +
                "aKyyd0xyT1H/ANeraqFUKowB2paKACiiigAooooAKpX8vSIfU1alcRxs57Cs1Fa4n92OSfSg\n" +
                "CWyg3t5jA7R09zWhTUUIoVegp1ABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUVBcz+\n" +
                "QowMsemaAJ6KpQ3rNKquowTjirtABRRRQAUUUUAFFFFABRRRQAUUVWuLoR5VMF/0FAEssyRD\n" +
                "LHnsO5rPmuXm4PC+gpgEk8hxlmPJq7DZomC/zH07f5/zigCjsbbu2nb644p0ULythRx3PYVr\n" +
                "UUARQW6Qjjlj1JqWiigAooooAKKKKACiiigAooooAKKKKACiiigAo60UUAZl3AIXBX7rdPam\n" +
                "QEiePBx8wqzqP/LP8f6VVh/18f8AvD+dAGvRRRQAUUUUAFFRPPEn3nH4c1BJfjkRpn3NAFyk\n" +
                "ZlUZZgB7ms17uZ8/NtHov+c1D8zt3Yn8aANGS8iQfKd59BUJv2zxGMfWqrIyY3KVz6jFNoA1\n" +
                "ILhZwccMOoqaqOnodzSfw4xV6gAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "msyopZjgCgB1RTTpCDk5bstVprxmJSEYHTPc/SiCzL/PNnnnHc/X/OaAELTXjbQNsff0/wDr\n" +
                "/SrMNskPI5b1NSqoVQFGAO1LQAUUUUAFFFFABRRRQAUUVFcS+VEW79B9aAKt9Lufyx0Xr9as\n" +
                "WsIijyR87dags4i7mZ+x4z3NXqACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKp\n" +
                "aj/yz/H+lXaq6h/qV/3v6GgClEcSoT2YVr1i1tUAFFFFABRRUU8whjJP3j0HrQBDdXTRvsjx\n" +
                "kdTS210ZW2OAG7Y71QYlmLHqTk1ds7cofMcYPYGgC5SMwRSzHAHemTTLCmWPPYetZ007zHnh\n" +
                "ewoAmnvGYlYuF9e5/wA/nUVvbtM3og6molxuGc4zzithVCKFUYA7UANjjWJAqjj+dPoooAKK\n" +
                "KKACiiigAooooAKKKKACiik3DdtyM+maAFooooAKKKKACiiigAooooAZLEsqbXzjrxUUdpHG\n" +
                "4YbiR0zUzuqLucgD3qrLfAEiNc+5/wAKALZIAyTgCoZLuJM/NuPoP84qmRcXPOGYduw/wqaO\n" +
                "w7yP+C0AMe+kP3FC/qabtuZ+oYj34FXo4I4/uKAfXvUlAFFbBiPmcA+wzUq2UQPO5vYmrNFA\n" +
                "ESwRJ0jX8eakZgilmOAO9BOBk9KzrufzW2r9wfqfWgCOeUzSlu3QfSnW8BmccEL3NOtbYync\n" +
                "/CfzrRVQihVGAKABVCKFUYA7UtFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUU13W\n" +
                "NdzkAVQnu2kBVBtX9TQBZnuli4XDP6elU/3t1J6/yFPt7RpMM+VT9TV9EVFCqMAUARQWyQ8/\n" +
                "eb1NT0UUAFFFFABRRRQAUUUUAFFFFABWdMxubkIp+UHA/qas3kvlwkD7zcCm2UOxPMP3m/lQ\n" +
                "BYRAiBV6CnUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVWvxmDPowNWagvP\n" +
                "+PZ/w/mKAMytqsWtqgAooqKedYV55bsKAFllWJCzfgPWs/Et1LnGT+gqSKJ7pzJKSF/zwKvK\n" +
                "qooVRgDtQBFDapFyfmb1NPmmWFNzdew9aJpVhQs34D1rMkkaVyzHn+VABJI0rlmPP8qI42lc\n" +
                "Ko5/lRFGZZAq9+p9K1Io1iQKv/66AI4rSOMg8sw7mp6KKACiiigAooooAKKKKACiiigAoooo\n" +
                "AiuHKQOw64xWV0rQvziEDPVqpRoZJFQdzQBpW7M0CF+pFS0gAVQB0HApaACiiigAopOnWqs9\n" +
                "4F+WLBPr2FAFl5FjXLsAKpy3rE4iGPc9aijhluW3MTg9WNXYbeOLkDLepoAqpayzMXkJXPc9\n" +
                "fyqzHaxRkHG4juanooAKKKKACiiigAooqpdXJB8qLljwSO3sPf8Az1oAZeXBJMSdP4j6+1Jb\n" +
                "Wm4b5Rx2X1qW2tQgDyD5+oHpVqgBAABgDAFLRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQA\n" +
                "UUVBPcpDx95/SgCYkAZJwBVWa9VeI8MfXt/9eqss8k33jx6DpRDA8zYAwO7dhQAn7y4k7s1X\n" +
                "YLRYyGb5mH5CpYokhXCD6n1qSgAooooAKKKKACiiigAooooAKKKKACkJAGTwKWq17Lsj2A/M\n" +
                "38qAIQPtd2T/AAD+X/16v1DaxeVCM/ePJqagAooqrcXYTKR8t69hQBLNMkK5Y89gOtVWv3z8\n" +
                "qKB78/4VVZizFmOSaSgDSt7oTHaw2t/OrFZlmCblcds5/KtOgAooooAKKKKACiiigAooooAK\n" +
                "KKKACiiigAqC8/49n/D+YqeoLz/j2f8AD+dAGaoLMAOpOK2ayIf9cmP7wq7c3YjykfL+vpQA\n" +
                "+4uVhGBgv6elQQW7THzZicHkD1/+tS29qSRJNnOc7T/WrtACAADAGAKR3EaFm6CnVR1Bmyq/\n" +
                "w9fxoArzSmaTceOwHoKYAScAZJpKs2MW+TeR8q/zoAt20PkxAH7x5NTUUUAFFFFABRRRQAUU\n" +
                "UUAFFFFABRRRQAUUUUAUNQb94i+gz/n8qLCPLGQ9BwPr/n+dQ3L753PvgfhV+0XbbpxgnmgC\n" +
                "aiikZgilmIAHegBaZLKkS5c49B3NVZr3tEP+BH/P+fSo4bd7hjJISAe/c0AJJNLctsUHH90f\n" +
                "1/zip4LNVAaXlvTsKsRxrEm1Bgfzp9ABRRRQAUUUUAFFFFABRRVa6uRENqHL/wAqAG3dwU/d\n" +
                "x/ePUjt/9eltLbYBI+d/p6Ulpb4/eycseQD/ADq3QAUUUUAFFFFABRRRQAUUUUAFFFFABRRR\n" +
                "QAUUUUAFFFFABWdfRsJi+PlbvWjRQBm21sZTubIT19a0VUIoVRgDtS0UAFFFFABRRRQAUUUU\n" +
                "AFFFFABRRRQAUUUUAISACScAVRizcXZc/dXkf0/xqW+l2x7AeW6/SpbaPyoQO55NAEtISFGS\n" +
                "QAO5oZgilmOAO9ZtxcNM2Bwg6CgB9xdmTKJwnr3NRQwPM3AwvdvSpba08wB5Mhew9avgAAAD\n" +
                "AFAFK4ijt4cAZduMn9f8+9U6nu5PMnOOi8CoKALenqfMZuwGP8/lV+q1iuLfP94k/wBKs0AF\n" +
                "FFFABRRRQAUUUUAFFIzBRliAPU1GLmEtgSDNAEtFFFABRRRQAVVv/wDUD/e/xqySFGSQAO5r\n" +
                "OurjzjtX7gPX1oAgBIOQcEVdtbXbiSQfN2HpVSH/AF8f+8P51r0AFFFFABWffS75NgPC9fr/\n" +
                "AJ/rVm6n8lMKRvPT296zKACtW2j8uBR3PJqjZx+ZOD2XmtOgAopMjOMjNLQAUUUUAFFFFABR\n" +
                "RRQAUUUUAFFFFABUdw5jgdh1A4qSqeoONqp3JzQBR61sKAiAZ4UYrJjYJIrHsc1JNcPNweF9\n" +
                "BQBamvETiP5m9e1U5JHmYbjk9gKaiNI21Bk1o29ssIBPL+tAENvZ9Hl/75/x/wAKu0UUAFFF\n" +
                "FABRRUUk8cX3mGfQdaAJaQkAZJwBVGS+Y5EahR6nk/5/OocTXDZwz9s9v8KAL0l1En8W4+i/\n" +
                "5xVdr9z91APrz/hRHYuRl2C+w5qR7eCGMs4LemT/AIUAVWuZmGDIfw4pqOVlDn5iDnk9aax3\n" +
                "MTgD2FLGhkkVB3OKANdWDKGHQjNLSABQAOAOBS0AFFFFABRRRQAUUUUAFFFFABRRRQAUUUUA\n" +
                "FFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFHSiq95JsgIHVuP8aAIY/wDS\n" +
                "Lwv/AAryP6f41dJwMnpUNnHsgB7tyaivpsDyl6nqf6UAQ3U/mvhT8g6e/vUlpa7sSSdOw9aS\n" +
                "zt92JX6DoPWr9ABUVzJ5cLMOvQVLWdfS75dgPC/zoArUUU6MbpFX1IFAGpCuyFFxjA5HvUlF\n" +
                "FABRRRQAUUx5EjGXYAVUe7kkbbAv44yaALckqRjLsBVSW+JyIlx7miOyZvmmYgnqByfzq1HD\n" +
                "HF91Rn170AZpWWU79rtnvimEEHBBz6Vs0UARwBhAgYYIHSpKKKACmu6xqWY4FJLIsSFmP/16\n" +
                "zZJHuZRxn+6o7UAOnnadsAHbnhaWW38q3DN98np6VatrYRDc3Ln9KbqH+oX/AHv6GgCparuu\n" +
                "EHvn8ua1azbFc3AP90E/0rSoAKhuLgQr6uegplxdCPKpy/6CqaRyXDk8nJ5Y9P8APtQAxmaR\n" +
                "yTyzGh0aMgNwSM49K0oLdIeRy3qaz538yZ2HQnigCxDNHbwD+J25IB/rUEtxJLwzYHoKiqaG\n" +
                "2klwQML/AHjQBDU1tO0LgE/ITyKfcWywxBgxLZwfSq4BJAHJNAGzRSDpS0AFFFFABRRRQAUU\n" +
                "UUAFFFFABWZePvuG5yF4/wA/jV25l8qIkfePArMJJOSck0AJU0Fu0x9FHU0+2tfNw78J6eta\n" +
                "AAAAAwBQA2KNYl2oOP50+iigAooooAQkKMsQB6mq0t6icJ85/Sqk8jySHeTwSAPSmxxtK4VR\n" +
                "z/KgB8l1LIMFsD0FOis5H5b5B79fyq3BbJDz95/Wp6AII7SJOSNx9TU9FFACMQqkk4A61mXM\n" +
                "xmk/2R0qS7uPMbYh+QdSO9VaACtCzg2LvYfM3T2FRWdvuIkcfKOnvV+gAooooAKKKKAComuI\n" +
                "V6yD8Of5VUvpdzhFIIHXHrVWgDYR1dQynINOqpp+fLbj5c8GrdABRRRQAUUUUAFFFFABRRRQ\n" +
                "AUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABVGX9/ehOqrwf6/4Vblfy4mf0HH1q\n" +
                "tYJndKxJJ4oAsyuIo2c9hWfBGbiclumctUl9KWkES9B/OrVvF5UIU9TyfrQBIAAAAMAUtFFA\n" +
                "DJn8uJn9BWSSWYk9TyatX0u5/LHReT9aqUAFSQDM8eP7wqOrFkpNwD6An+lAGlRSEgDJOAKr\n" +
                "S3ig7Yhvb9P/AK9AFlmCrliAPU1UkvCzbIF3E98f0pFtpZ23zsQPTv8A/Wq1HGkS4QYoArR2\n" +
                "jO2+djknp/n+lWkRY12oABTqKACiiigAooooAKimnSFck5PZe5qO5uhENqYL/wAqpKHnl/vM\n" +
                "epoACZLiX1Y9h2rQt7dYV9XPU06GFYUwvJ7n1qSgAqtfgmAY7NzVgkAZJwBVG7uVdfLTkZ5N\n" +
                "ACWTJHvkc4HQe/8Anikmu2kBVBtU8e5qCONpG2oMmtG3tlh+Y8v6+n0oAggsy2GlyB/dq6qh\n" +
                "VCqMAUtFAEN2+y3b1PA/Gq1rbLLEzPnk4FF+5aRYx0HOPerkKeXEq+g5+tAEMdlGhyx3ntnp\n" +
                "VmiigChqDZkVewGajs033C8cLz/n8abctuuHPvj8uKt2CbYi/dj+lAFqiiigAooooAKKKKAC\n" +
                "ikZgoyxAHqaYk0bttVwT6UASUUUUAZ18+6bb2UVXRd7qo6k4qa8/4+X/AA/kKWyXdcA/3QTQ\n" +
                "BoqoVQo6AYpaKKACiiigAooooArzWiSPuBKk9cd6lijWJNqDin0UAFFFFABVO8uQAYk6nhj6\n" +
                "e1OuLtVBWM5b1HQVn9etABU9pEsshDHgDOPWoSCDgjBqzp/+vb/d/qKAL4GBgdKWiigAoqOW\n" +
                "aOIfM3PoOtVGnnuMrEpC+3+NAFqa4jiByct/dFUpLiWc7VyAf4VqeKxUcyHcfQdKsoiouEUA\n" +
                "e1AFCOykflvkH5mrMdnEmMjcfU1YooAQAAYAwBS0UUAFFFFABRRRQAUUUUAFFFFABRRRQAUU\n" +
                "UUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAU7+ThYx35NS5+zWgz1A6e/wD+uqyfv77PUA54\n" +
                "9B0pb+UmQRjovJ+tADbRDLcb25x8x+taNQWceyAHu3NT0AFRzSCKIt37fWpKzr2XfJsBO1f5\n" +
                "0AV2JZiT1PJpKKeqgIzMR6KPU/5/WgBlT20qQ7nbJboAKgrQtIEEauy5c889vSgCMLcXXLnZ\n" +
                "Gf8AP4/jVmK3ji+6Mn1PWpaKACiiigAooooAKKKKACql1dbcxxn5u59KnmLCFyn3scVlEknJ\n" +
                "OSaAFAaR8DJYmtK2gEK+rnqahsoNo81up6D+tWJZUiXLn6D1oAkqtNeImQnzN7dKqzXUkuRn\n" +
                "avoKhVS7BVGSe1AD5ZnlPztx6dqRo2WMOwwG6e9Xbe0VAGkGW9OwqPUCMoO4yaAJbAYgz6sT\n" +
                "VmoLP/j2T8f5mp6ACkJAGTwKWobt9lu3qeP8/hQBUh/f3u7nGd34Dp/StGqlhHhDIRyeB9Kt\n" +
                "0AFNkbZGzegzTqrX77YQvdj+n+cUAUFUu4UdScVrIoRAo6AYqjYJulL9lH61oUAFFFVLq6aN\n" +
                "ykeMjqTQBbpjzRpnc6gjtnmsx5pHzudjntnio6ANF72Jfugt+GKrveyt93Cj2FVqlS3lfohx\n" +
                "6nigCNmZzlmJPuaFzuG3Oc8YoIwSMg47irtnbAASv16qP60AW1ztG772OaWiigCGW2jlbc2Q\n" +
                "fUd6WGBIc7cknualooAKKKKACiiigAooooAKKKKACs26nd5GUEhQcYHetBmVFLMcAVmsrXM7\n" +
                "GNeCf85oAiALHABJ9BV+2tAmHk5bsOw/+vT7e3WFecFz1P8AhU9AGZef8fL/AIfyFP0//Xt/\n" +
                "u/1FMvP+Pl/w/kKZDI0TkoMsRgUAajusa7nIAqpJdSStsgU/Xv8A/WpEtpJm3zsQPTv/APWq\n" +
                "4kaRrhFAFAFWKzyd05LE9s/zq2AFGFAA9BS0UAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFF\n" +
                "FFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVFcv5cDEHnGBUtUtQf7sf8AwI0ANs8R\n" +
                "xSTHtwP8+/FQxqZrgA87jk/1p0r7YY4h2G4/U1Lp6Euz9gMUAXQMDApaKQkKMkgD1NACPu2N\n" +
                "t+9jj61kHOTuznvmr0l3k7IAWY98UkdoztvnbJPYf5/lQBUjjeQ4RSatpYjYd7fMfToKtKqo\n" +
                "oVQABTqAKAsX3csuM1eUBVCjoBgUtFABRUcsyRDLn6DuaoTXUkmQDtX0FAF6S4ij+82T6Dk1\n" +
                "Xe//ALifi3+f61Spyo7/AHVLfQUAWPt0v91PyP8AjR9ul/up+R/xpn2Sf+5+opDazAE7P1FA\n" +
                "E8d+P+WifitWo5Y5PuMD7VksrKcMCD6EUKxU5UkH1FAGzURtoS24oM1Ha3Pmja/3x+tWaAGS\n" +
                "OsUZY9FHSsuSRpXLMef5Vo3YJtnA/wA81l0APiieVsIPqfStKGBIVwoye7dzTLJlMACgAjr/\n" +
                "AI1YoAKz9Q/16/7v9TWhWZekm5b2x/KgC9bLtt0Htn8+alpkPEMf+6P5U+gAqjqDnKx/jV6q\n" +
                "H+t1DvhT/L/69AFyFPLiVcYwOfrT6KKACs29fdOR2UYq/K4jjZz2FZsS+dcAN/Ecn+dAF6zT\n" +
                "Zbr6tz/n8KnoprOqDLMAPc0AOrPvIHErSKpKnnjtVn7XB/f/AENSRyJIMowNAGRRWrJbxSfe\n" +
                "QZ9RxVaSxP8Ayzb8GoAiguPKIyinHfHP51NPdo8BEZO5uCCO1VpIZIvvqQD3qOgC1Z2/mNvc\n" +
                "fIOnuf8ACtCslJpI/uOQPTtVmO+/56L+K0AXaKZHLHJ9xgfbvT6ACiiigAooooAKKKKACiii\n" +
                "gAqOWZIVyx+g7mmXFysIIHL+lRQ27yv5lxz6Kf8AP6UANVJLt9z5WLsP8/zq4qqihVGAKUAA\n" +
                "YAwBSO6xruc4FADqgmuo4sjO5vQVA9zJO2yAED9f/rVJBZqnMmGb07UAUpXMkhdgAT6VNYAG\n" +
                "c+y/4VFcHM7/AO8am0//AF7f7v8AUUAaFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRR\n" +
                "RQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABWZcuGuWJyVBxj6VoyNsjZvQZrI\n" +
                "JJJJ5JoAGYsxY9TWlaJst19W5P8An6VmrjcN33c84q4ZJrn5Yhsj9en+fwoAmmukiBAO5/QV\n" +
                "CIZrkhpiVT+7/wDW/wAamhtY4sHG5vU1PQBHHEkQwi49+5qSiigAooooAKr3NyIhtXl/5Ul1\n" +
                "ciIbU5c/pWfyx5OSe5oAV3Z2LMSSafFbyS8qML6npUkC268yuC3oAcf/AF/5VcWeEj5XUAdu\n" +
                "lADI7OJOWG8+/wDhU4AUYAAHoKAQRkEEeopaACiiigBrorrh1BHvWZcxrHMVQ8enpWhPMIYy\n" +
                "T949B61lsSzFjyScmgCS13faE29c/p3/AErVqjYw8+afoKvUAIQCMEZBrLuYTDKRj5TyK1aj\n" +
                "niEsRU9eo+tAGbDKYpAw/EeorURg6BlPBrIZSjFWGCKs2dx5bbHPyHp7GgDQrLuMyXTADktj\n" +
                "+lalZcWZLtSO77v60AalFFFADZG2Rs3oM1UsEJLyH6f41LfNtt8f3jj+tLZrtt14wTyf8/Sg\n" +
                "CeiikY7VJxnAzgUAUb6Yl/KHQdfrTLR0jZnc4wMAetQMxZix6k5pKALct65OIvlHqRzVVmLH\n" +
                "LEk+ppURpGwikmrcVjxmVvwH+f8APrQBSqW2cpcIR3OD+NLdKiTbYxgAc0WqhrhAexzQBqUj\n" +
                "MEUsxwB3oJAGScAVnXVyZTtXhB+tADJ5TPLkA46KKuQ2qCECRQWPJ9qhsodzeYw4HT3P/wBa\n" +
                "r9AFV7GM52llP5j/AD+NV3s5V6AMPatKigDHIZG5yrD8DU0d5KnDYce/WtB40kGHUH61Umse\n" +
                "8R/4Cf8AP+fWgCaO6ik/i2n0ap6x3Ro22upBqSK5kiwA2V9DQBqUVBFdRycZ2t6Gp6ACiikZ\n" +
                "gilmOAO9AC1UnuiSI4PmY9xUU1w87+XFnaePc/5//XVmCBIEyxG7ux7UANt7UIQ8nzP1+n/1\n" +
                "6sEhRliAPU1WlvUXIT5m9e3+f85qo0ktw+OW9FHT/PvQBZmvQBiLk/3jUUUElw++Qnb6n+n+\n" +
                "cVNBZhfmlwT2Hb/P6Va6dKAGxxrGu1BgU+iigDIm/wBfJ/vH+dWdPHzufQYqq7bnZvU5q5p6\n" +
                "/I7epx/n86ALlFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAU\n" +
                "UUUAFFFFABRRRQAUUUUAFFFQzXKQ8E5b0FADL5tsGP7xxWdU8xmlUSOpCdvQf59aiRC7hV6k\n" +
                "0AWbO3Eg3uOM8D1q8AAMAYA7CmxoI4wg6Cn0AFFQyXMUZILZI7Cqkl7I3CYUfmaANBmCjLEA\n" +
                "epNQPeRJwCWPtVJY5pznDN7mp1sD/G4H0FACNfOT8qqB781H9rn/AL/6CpZ7aGGMtufPYZ7/\n" +
                "AJVToAUAu4HVmNS3EXksq5ySuT9aLRN9wvovJ/z9asahHlVkA6cH/P8AnrQBRooq/FBBNCGC\n" +
                "4J64PQ0AUld0+6xX6GrEd7Ip+cBh+Rp0liesbZ9mqtJFJH99SPftQBox3MUnAbB9DxTpplhT\n" +
                "Ldew9ayaVmZjliSfc0AOkkaVyzHn+VOghM0gA+6Op9KSGIzSbRx3J9BWnFGsSBV6fzoAcqhF\n" +
                "CqMAUtFFABRRRQBVvLfzF3oPnHXHcVn1tVn3kGxvMUfKevsaAHRXX+jsjnDBcKajsVzcA/3Q\n" +
                "T/T+tV6t6ep8xm7AY/z+VAF+iiigChfsWlRBzgfzq6i7EVfQYqif3moccYb+X/6q0KACiiig\n" +
                "ClNZFnJjKgHse1OjsUHMhLH0HAq3RQA1EVFwoAHtSsQqlj0AyaWq19Jsh2g8scfhQBQkbfIz\n" +
                "epzVqwTBeQnCgYqnUhlPlCMcL1PuaAJrq58zKIfk7n1qGCIzSBR06n6U1EMjhV6mtOCFYYwB\n" +
                "1PU+tAD1UIoVRgCnUUUAFFFFABRRRQA10V12uAR71Umsu8R/4Cf8/wCfWrtFAGMylWKsCCOx\n" +
                "qaG6kiwCdy+hq7PAsyngBuxrOkieJtrjHv60AaQuIjEZN3A6jvWfPO0zHJ+XPAqKigCxFOkE\n" +
                "fyLukPUnp/n+tRyTSS/fYkenaiKCSU/KvHqelXobRI8M3zOO/YUAVYbR5MFvlX9TV+KJIlwg\n" +
                "x79zT6KACiiigAprttRm9BmnVHOQIJM/3TQBk1o2KkW+fUk/0rOrVtl226D2z+fNAEtFFFAB\n" +
                "RRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRSEgDJO\n" +
                "AKAFpryLGuXYAVWnvAuVi5Pr2qvHFLctuYnH94/0oAle5kmbZApHv3/+tUkNoFO6X53P4ipo\n" +
                "oUiGEH1Pc1JQAhAIwRkHtTY4o4/uKB705mCjLEADuapzXvaL/vo0AWpZUiXLnHoO5qjNdu5I\n" +
                "Q7V9utRKsk8mMlmPc9qtLDDbKGlIZ/T/AAH+P6UAV4rWSXnG1fU1djtIk6jcfU/4VGb9M8Ix\n" +
                "HvUkd1FIcA7T6NQBN06UtFVrq5EQ2py5/SgCC/YGUAEkgcj0qrSkknJOSatWVvuIlboOgoAs\n" +
                "WkPlRZI+ZuTUroHQq3QinUUAZEsZikKt26H1pYZnhbKHr1B6GtKaFZkw3B7H0qhJayoeF3D1\n" +
                "FAE32/j/AFfP1qCW5lkGCcD0FNEEpOPLb8qmjspGI3kKPzNAFWnNG6AFlK59RWlFbRREELk+\n" +
                "pqR0V12sAR70AZCsUYMpwR3q/b3YfCScN69jUc9mR80XI/u9/wAKqEEHBGCKANmis+3u2jws\n" +
                "nKevcVfVg6hlOQe9AC0UUUAFIQGBBGQetLRQBSksSXzGwCnse1WIIRCm0HJPJNS0UAFIzBVL\n" +
                "HoBmlqK6bbbuR6Y/PigCpZDfclm5IBOfetCqmnr8jt6nH+fzq3QAUUUUAFFFFABWbfNuuMf3\n" +
                "QB/WtKql1amRt8fXuM9aAKFORGkbagyasR2UjEb8KO/PNXIoUiGEH1Pc0ANt7cQr6uepqaii\n" +
                "gAooooAKKKKACiiigAooooAKa6LIu1xkU6igCk9hz+7fj/aqVLSJQMjcR3NWKKAEAAGAMAUt\n" +
                "FFABRRRQAUUUUAFQXhAtm564AqeqmoMPLVe5Of8AP50AUK2EXair6DFZMQDSop6FgK2KACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiopbiOI4Y5\n" +
                "b0FUZrqSXIztX0FAFuW7jjyB8ze1UpJ5Zjgng/wimRxtI21Bk1o29ssIBPL+tAEFvZ5w0vT+\n" +
                "7/jV0AAYAwPQUtFABUU06Qr8xy3ZfWpayrkMLh92c54+nagBJZnlPzHj0HSlhgeZsAYXu3YU\n" +
                "tvA0zeijqa0kRY0CqMAUAMwltCSBwB+dZskjSuWY8/yq5qDYjRfU5qiBkgcDPrQAYNJWkJYL\n" +
                "eMKrA/7vOaoTOryEogUegoAkS6lRNoII7E9qhJJOSck0lPiKK+XXcB296AJra2Mp3OMJ/OtA\n" +
                "AAYAwBVBb5wQCi7R2Aq8jB0DDoRmgB1FFFABRRRQAUUUUAFFFFABUFxbLMCRw/rU9FAGMylG\n" +
                "KsMEdqmtpzC+D9w9R/WrtxbiZeOHHQ1UitJPMXeuFzzzQBo0UUUAFFFFABRRRQAVWvyRBgd2\n" +
                "ANWao6g3KJn3NAE9mALZeOuSanpkIxCg/wBkU+gAooooAKKKKACiiigAooooAKKKKACiiigA\n" +
                "ooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACs/UCfOUdttaFZl6SblgewAFADbZd1\n" +
                "wgHrn8ua1azLMZuV9s/yrToAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAqrezPGFVDjPU1aqKeETJg8EdDQBlkknJOSamt7ZpiCeE9f8KsQ2QU5lIYjoB0\n" +
                "q0AAMAYAoAbHEkS7UGPf1p9FFABRRRQAUySGOX76g+9PooARVCKFUYA7UtFFAFe9jLw5UZKn\n" +
                "P4Vm1tVE1vCzbigz7cUAZaqzHCqSfYVYjspGI34UfrV9VVBhVCj2FOoApz2aiLMQJYfrVGtq\n" +
                "qVzaMzl4uc9RQBTUFmAHU8CteNdiKo7DFVLa1dZA8gAx0Ge9XaACiiigAooooAKKKKACiiig\n" +
                "AooooAKKKKACiiigAooooAKKKKACs68zJdBB14X/AD+daBIUZYgD1NZpbffBuPvjp9aANOii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACsy8/4+X/D+QrTrMvP+Pl/w/kKAH2H+vP8Au/1FaFZ+n/69v93+orQoAKKKKACiiigA\n" +
                "ooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKK\n" +
                "KACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigA\n" +
                "ooooAp6gx2ovY5NVITiZCf7wq/dwGZV2kZX1qtHaSmRd6YXPPNAGjRRRQAUUUUAFFFFABRRR\n" +
                "QAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAQzXMcLBWyT7ULdQtgbwD78VVu4ZDOWVSw\n" +
                "b0FQeTL/AM83/wC+TQBqedF/z0T/AL6FHnRf89E/76FZTIyfeUr9RTaANfzov+eif99CkM0Q\n" +
                "/wCWifnWTRQBqG6hB+/+hpDeQgcMT7AGsyigC+1+mPlRiffiqcshlkLtgE+lNAJOACT6CpUt\n" +
                "Zn/gwPU8f/XoAk0//Xt/u/1FaFQ29uIV9XPU1NQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQA\n" +
                "UUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFF\n" +
                "FABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQA\n" +
                "UUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFMMUZOTGh/AU+igCJre\n" +
                "Fusa/hx/Km/ZIP7n6n/Gp6KAIRawj+D9TTvJi/55p/3yKkooAQAKMKAB6CloooAKKKKACiii\n" +
                "gAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigD//2Q==\n" +
                "\" /><span style=\"\"></span><span style=\"\"></span><span style=\"\"><span style=\"display:inline-block;width:8px;height:8px;visibility:hidden;color:transparent;\"></span></span><span style=\"\"></span></p></section></div><footer><p style=\"text-align:center;line-height:1pt;display:block;\"><span style=\"\"></span><span style=\"\"></span><span style=\"\"></span>&nbsp;</p><table style=\"width:100%;border-spacing:0px;border-collapse: collapse;\"><colgroup></colgroup><tr style=\"height:;\" ><td colspan=1  rowspan=1 style=\"border:1px solid #000;width:;border:0.8px solid #000;border-style:solid;border-top-style:solid;border-bottom-style:solid;border-right-style:solid;border-left-style:solid;border-left-color:#000000;border-bottom-style:none;border-right-color:#000000;border-top-color:#000000;border-left-style:none;border-bottom-color:#000000;border-right-style:none;border-top-style:none;\"><p style=\"text-align:center;display:block;\"><span style=\"\">第</span><span style=\"\"></span><span style=\"\">/</span><span style=\"\"></span><span style=\"\">页</span></p></td></tr></table><p style=\"text-align:center;line-height:1pt;display:block;\"><span style=\"\"></span>&nbsp;</p></footer></div></body></html>";
        // 加载一个 HTML 文件

        ByteArrayOutputStream byteArrayOutputStream = conformHtmlToPdf(str);

        try {
            addMark(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}