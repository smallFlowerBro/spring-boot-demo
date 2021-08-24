package com.wei.schedule.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author weiyongjian
 * @Description 的静态定时任务
 * @Date
 */
@Configuration
@EnableScheduling
public class StaticScheduleTask {

    /*直接定义频率*/
    @Scheduled(cron = "*/5 * * * * ?")
    private void task1(){
        System.out.println("静态定时任务1");
    }

    @Scheduled(fixedRate = 5000)
    private void task2(){
        System.out.println("静态定时任务2");
    }
    /*从配置文件获取*/
    @Scheduled(cron="${task.task3}" )
    private void task3(){
        System.out.println("静态定时任务3");
    }
}
