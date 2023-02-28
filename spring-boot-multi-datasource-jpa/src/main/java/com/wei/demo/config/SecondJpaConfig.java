package com.wei.demo.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
 * @Description 第二数据源jpa 配置类
 * @Date
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = SecondJpaConfig.BASE_REPOSITORY_PACKAGE,
        transactionManagerRef ="secondTransactionManager",
        entityManagerFactoryRef = "secondEntityManagerFactory"
)
public class SecondJpaConfig {
    /*主数据库包扫描路径*/
    public  static final String BASE_REPOSITORY_PACKAGE = "com.wei.demo.second.repository";
    public  static final String BASE_ENTITY_PACKAGE     = "com.wei.demo.second.entity";

    /**
     * @return   第二数据源jpa配置
     */
    @Bean(name = "secondJpaProperties")
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.ddl-auto","update");
        return properties;
    }


    /**
     * @param dataSource
     * @param jpaProperties
     * @return
     */
    @Bean(name = "secondEntityManagerFactory")
    public EntityManagerFactory localEntityManagerFactoryBean(
            @Qualifier("secondDatasource") DataSource dataSource,
            @Qualifier("secondJpaProperties") Properties jpaProperties){

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
     * @return 第二数据库实体类管理对象
     */

    @Bean(name="secondEntityManager")
    public EntityManager entityManager(@Qualifier("secondEntityManagerFactory") EntityManagerFactory localContainerEntityManagerFactoryBean){
        return localContainerEntityManagerFactoryBean.createEntityManager();
    }

    /**
     * @param entityManager
     * @return 第二数据库事务管理
     */

    @Bean(name="secondTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("secondEntityManagerFactory") EntityManagerFactory entityManager){
        return new JpaTransactionManager(entityManager);
    }
}
