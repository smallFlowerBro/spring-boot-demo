package com.wei.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2024/3/27 11:36
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
@Component
public class ArgsBean {
    @Autowired
    private ApplicationArguments arguments;


    public void printArgs(){
        System.out.println("# 非选项参数数量: "+arguments.getNonOptionArgs().size());
        System.out.println("# 选项参数数量: "+arguments.getNonOptionArgs().size());
        System.out.println("# 非选项参数具体参数");
        arguments.getNonOptionArgs().forEach(System.out::println);
        System.out.println("# 非选项参数具体参数");
        arguments.getOptionNames().forEach(optionName->{
            System.out.println("--"+optionName+"="+arguments.getOptionValues(optionName));
        });
    }


}
