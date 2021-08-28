package com.wei.multidatasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Configuration
public class PrimaryDataSourceConfig {

    /**
     * @return  获取主数据源配置
     */
    @Primary
    @Bean("primaryDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSourceProperties dataSourceProperties(){return new DataSourceProperties();}

    /**
     * @param dataSourceProperties
     * @return 获取主数据源
     */
    @Primary
    @Bean("primaryDataSource")
    public  DataSource dataSource(@Qualifier("primaryDataSourceProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }



}
