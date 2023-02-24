package com.wei.demo.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.*;
import java.util.Base64;
import java.util.HashMap;

/**
 * @Author weiyongjian
 * @Description
 * @Date
 */
public class QRCodeEncode {
    /**
     * @param content  内容
     * @param barcodeFormat  条码类型
     * @param width  图片高度
     * @param height 图片宽度
     * @return
     */
    public static String encodeToBase64(String content, BarcodeFormat barcodeFormat,int width,int height,String image_type){
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            HashMap<EncodeHintType, Object> encodeHintTypeObjectHashMap = new HashMap<>();
            encodeHintTypeObjectHashMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, barcodeFormat, width, height, encodeHintTypeObjectHashMap);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix,image_type,byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return  encoder.encodeToString(bytes);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return "";
        }


    }
    public static String encodeToBase64(String content, BarcodeFormat barcodeFormat,int width,int height){
        return encodeToBase64(content,barcodeFormat,width,height,ImageType.PNG.getType());


    }

    /**
     * @Description 将信息生成条码图片
     * @param content   内容
     * @param barcodeFormat  条码类型
     * @param width  宽
     * @param height 高
     * @param fileName  文件名
     * @param image_type 文件类型
     */
    public static void encodeToImage(String content,BarcodeFormat barcodeFormat,int width,int height,String fileName,String image_type){
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            HashMap<EncodeHintType, Object> encodeHintTypeObjectHashMap = new HashMap<>();
            encodeHintTypeObjectHashMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, barcodeFormat, width, height, encodeHintTypeObjectHashMap);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix,image_type,byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void encodeToImage(String content,BarcodeFormat barcodeFormat,int width,int height,String fileName){
        encodeToImage(content,barcodeFormat,width,height,fileName,ImageType.PNG.getType());
    }

    public static void main(String[] args) {
        System.out.println(QRCodeEncode.encodeToBase64("HelloWorld",BarcodeFormat.QR_CODE,50,50));
        QRCodeEncode.encodeToImage("HELLOWORLD",BarcodeFormat.CODE_39,50,50,"HL.png");
    }
}
