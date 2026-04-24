/**
 * 海到尽头天作岸 山登绝顶我为峰
 *
 * @Author Administrator
 * @CreateTime 2026-03-20 11:21
 * @Description
 **/
package com.wei.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {

        System.out.println("xxxxxxxxxxxxxx");
        // 检查是否有错误参数
        String error = request.getParameter("error");
        if ("true".equals(error)) {
            model.addAttribute("errorMessage", "用户名或密码错误！");
        }
        return "login"; // 返回名为 login 的 Thymeleaf 模板
    }
}
