package com.wei;

import com.wei.config.ArgsBean;
import com.wei.config.LearnApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootPrincipleApplication {
    public static void main(String[] args) {

        //SpringApplication.run(SpringBootPrincipleApplication.class,args);
        SpringApplication app = new SpringApplication(SpringBootPrincipleApplication.class);
        app.addInitializers(new LearnApplicationContextInitializer());
        ConfigurableApplicationContext context = app.run(args);
        ArgsBean bean = context.getBean(ArgsBean.class);
        bean.printArgs();
    }
}