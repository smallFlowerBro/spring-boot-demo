package com.wei.demo.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class QRCodeDecode {

    /**
     * @Descriton 接收base64形式的条码图片字符串，解析并返回条码数据内容
     * @param base64
     * @return
     */
    public static String decodeFromBase64(String base64){
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            byte[] bytes = decoder.decode(base64);
            BufferedImage bufferImg = ImageIO.read(new ByteArrayInputStream(bytes));
            BufferedImageLuminanceSource bufferedImageLuminanceSource = new BufferedImageLuminanceSource(bufferImg);
            HybridBinarizer hybridBinarizer = new HybridBinarizer(bufferedImageLuminanceSource);
            BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);
            HashMap<DecodeHintType, Object> decodeHintTypeObjectHashMap = new HashMap<>();
            decodeHintTypeObjectHashMap.put(DecodeHintType.CHARACTER_SET,"UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, decodeHintTypeObjectHashMap);
            return result.getText();
        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @Description  解析条码图片中的信息
     * @param file
     * @return
     */
    public static String decodeFromFile(File file){
        try {
            BufferedImage bufferImg = ImageIO.read(file);
            BufferedImageLuminanceSource bufferedImageLuminanceSource = new BufferedImageLuminanceSource(bufferImg);
            HybridBinarizer hybridBinarizer = new HybridBinarizer(bufferedImageLuminanceSource);
            BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);
            HashMap<DecodeHintType, Object> decodeHintTypeObjectHashMap = new HashMap<>();
            decodeHintTypeObjectHashMap.put(DecodeHintType.CHARACTER_SET,"UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, decodeHintTypeObjectHashMap);
            return result.getText();
        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static String decodeFromFile(String string){
        return decodeFromFile(new File(string));
    }

    public static void main(String[] args) {
        String base64str ="iVBORw0KGgoAAAANSUhEUgAAADIAAAAyAQAAAAA2RLUcAAAAc0lEQVR4XmP4DwYHGOhG/2EPkAfRf7+G3wfToibxYFr8CoQWEYHQX8rB8n9YIer//4Xq3yxoD5ZfbzsfRP8rXg3hr4oHq/vTqAnWD1QAUc/atB8s/30lWP1fsVMQ9aKfIPaLzYbQX5gh+llugOXR3U0fGgA2ZS9dq2PyJwAAAABJRU5ErkJggg==";
        System.out.println(QRCodeDecode.decodeFromBase64(base64str));
        System.out.println(QRCodeDecode.decodeFromFile("hl.png"));
    }
}
