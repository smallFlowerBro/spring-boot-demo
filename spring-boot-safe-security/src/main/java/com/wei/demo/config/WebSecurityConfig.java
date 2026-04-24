package com.wei.demo.config;

import com.wei.demo.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*********************************
 *   @Author WEIYJ
 *   @Description Security配置类
 *   @Data 2023/2/10 10:17
 ********************************/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {


    @Bean
    public PasswordEncoder passwordEncoder(){
        // 推荐使用 BCrypt 对密码进行加密存储
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/","/favicon.ico").permitAll() // 首页公开访问
                        .requestMatchers("/login").permitAll() // 登录页公开访问
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() // 静态资源公开访问
                        .anyRequest().authenticated() // 其他所有请求都需要认证
                )
                .formLogin(form -> form
                        .loginPage("/login") // 自定义登录页面URL
                        .defaultSuccessUrl("/dashboard", true) // 登录成功后默认跳转的页面
                        .failureUrl("/login?error=true") // 登录失败后跳转的URL
                        .usernameParameter("username") // 登录表单中用户名字段的name属性
                        .passwordParameter("password") // 登录表单中密码字段的name属性
                        .permitAll() // 允许所有人访问登录页面和登录功能
                )
                .logout(logout -> logout
                        .logoutUrl("/perform_logout") // 自定义登出URL
                        .logoutSuccessUrl("/") // 登出成功后跳转的页面
                        .invalidateHttpSession(true) // 登出时使Session失效
                        .clearAuthentication(true) // 清除认证信息
                        .permitAll()
                )
                .rememberMe(remember -> remember
                        .key("uniqueAndSecret") // 用于生成Remember-Me Cookie的密钥
                        .tokenValiditySeconds(86400) // Remember-Me token的有效期（秒），这里是24小时
                        .userDetailsService(userDetailsService()) // 必须注入UserDetailsService
                );

        return http.build();
    }


    public UserDetailsService userDetailsService(){
        return new CustomUserDetailService();
    }
}
