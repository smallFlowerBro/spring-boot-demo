package com.wei.demo.controller;

import com.wei.demo.MimeSender;
import com.wei.demo.TextSender;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @Autowired
    private TextSender textSender;
    @Autowired
    private MimeSender mimeSender;
    @GetMapping("/test")
    public  String  test(HttpServletRequest request){
        String remoteHost = request.getRemoteAddr();
        File text = new File("text.txt");
        try {
            FileWriter fileWriter = new FileWriter(text);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hello");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //textSender.send("ip地址",remoteHost,"1262405508@qq.com");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("text.txt");
        mimeSender.send("1262405508@qq.com","测试",remoteHost,strings,strings);
        return "hello test";
    }
}
