package com.wei.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import sun.misc.BASE64Decoder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] bytes = base64Decoder.decodeBuffer(base64);
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
//        String s = QRCodeDecode.decodeFromBase64("iVBORw0KGgoAAAANSUhEUgAAADIAAAAyAQAAAAA2RLUcAAAAcklEQVR42mP4DwYHGOhG/2EPkAfR\n" +
//                "f7+G3wfToibxYFr8CoQWEYHQX8rB8n9YIer//4Xq3yxoD5ZfbzsfRP8rXg3hr4oHq/vTqBkPUb8e\n" +
//                "op61aT9Y/vtKsPq/Yqcg6kU/QewXmw2hvzBD9LPcsKdneKDSADZlL11UCGgoAAAAAElFTkSuQmCC");
        String s = QRCodeDecode.decodeFromFile("HL.png");
        System.out.println(s);
    }
}
