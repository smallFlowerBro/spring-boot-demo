package com.wei.shiro.contoller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("list")
    @RequiresRoles("admin")
    public String orderList(){
        return "orderList";
    }

    @GetMapping("detail")
    public String orderDetail(){
        return "orderDetail";
    }

}
