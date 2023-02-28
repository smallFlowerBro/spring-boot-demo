package com.wei.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Configuration
public class SecondDataSourceConfig {
    /**
     * @return  获取主数据源配置
     */

    @Bean("secondDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSourceProperties dataSourceProperties(){return new DataSourceProperties();}

    /**
     * @param dataSourceProperties
     * @return 获取第二数据源
     */
    @Bean("secondDataSource")
    public DataSource dataSource(@Qualifier("secondDataSourceProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
