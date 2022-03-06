package com.wei.email.controller;

import com.wei.email.MimeSender;
import com.wei.email.TextSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
