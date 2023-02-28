package com.wei.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Author weiyongjian
 * @Description 第二数据源配置类
 * @Date
 */
@Configuration
public class SecondDatasourceConfig {

    /**
     * @return   第二数据源配置
     */
    @Bean(name="secondDatasourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }


    /**
     * @param dataSourceProperties
     * @return  获取第二数据源
     */

    @Bean(name = "secondDatasource")
    public DataSource dataSource(@Qualifier("secondDatasourceProperties") DataSourceProperties dataSourceProperties){
        return  dataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     * @param dataSource
     * @return  获取第二数据源模板
     */
    @Bean(name="secondDatasourceTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("secondDatasource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
