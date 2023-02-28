package com.wei.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Author weiyongjian
 * @Description 主数据库配置类
 * @Date
 */
@Configuration
public class PrimaryDatasourceConfig {

    /*主数据源配置*/
    @Primary
    @Bean(name="primaryDatasourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    /*获取主数据源*/
    @Primary
    @Bean(name = "primaryDatasource")
    public DataSource dataSource(@Qualifier("primaryDatasourceProperties") DataSourceProperties dataSourceProperties){
        return  dataSourceProperties.initializeDataSourceBuilder().build();
    }
    /*主数据源template*/
    @Primary
    @Bean(name="primaryDatasourceTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("primaryDatasource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
