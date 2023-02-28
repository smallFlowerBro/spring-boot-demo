package com.wei.demo.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author weiyongjian
 * @Description 主数据源jpa配置
 * @Date
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = PrimaryJpaConfig.BASE_REPOSITORY_PACKAGE,
        transactionManagerRef ="primaryTransactionManager",
        entityManagerFactoryRef = "primaryEntityManagerFactory"
)
public class PrimaryJpaConfig {
    public  static final String BASE_REPOSITORY_PACKAGE="com.wei.demo.primary.repository";
    public  static final String BASE_ENTITY_PACKAGE="com.wei.demo.primary.entity";


    /**
     * @return   主数据源jpa配置
     */
    @Primary
    @Bean(name = "primaryJpaProperties")
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.ddl-auto","update");
        return properties;
    }
    /**
     * @param dataSource
     * @param jpaProperties
     * @return 主数据库实体管理工厂
     */
    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public EntityManagerFactory localEntityManagerFactoryBean(
            @Qualifier("primaryDatasource") DataSource dataSource,
            @Qualifier("primaryJpaProperties") Properties jpaProperties){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(false);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaProperties(jpaProperties);
        factory.setPackagesToScan(BASE_ENTITY_PACKAGE);
        factory.setDataSource(dataSource);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    /**
     * @param localContainerEntityManagerFactoryBean
     * @return 主数据库实体类管理对象
     */
    @Primary
    @Bean(name="primaryEntityManager")
    public EntityManager entityManager(
            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory localContainerEntityManagerFactoryBean){
        return localContainerEntityManagerFactoryBean.createEntityManager();
    }

    /**
     * @param entityManager
     * @return 主数据库事务管理
     */
    @Primary
    @Bean(name="primaryTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManager){
        return new JpaTransactionManager(entityManager);
    }





}
