package com.wei.multidatasource.config;

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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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
    /*主数据库包扫描路径*/
    public  static final String BASE_REPOSITORY_PACKAGE="com.wei.multidatasource.primary.repository";
    public  static final String BASE_ENTITY_PACKAGE="com.wei.multidatasource.primary.entity";

    /**
     * @return   主数据源jpa配置
     */
    @Primary
    @Bean(name = "primaryJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.primary")
    public JpaProperties jpaProperties(){
        return new JpaProperties();
    }

    /**
     * @param dataSource
     * @param jpaProperties
     * @param build
     * @return 主数据库实体管理工厂
     */
    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean(
            @Qualifier("primaryDatasource") DataSource dataSource,
            @Qualifier("primaryJpaProperties") JpaProperties jpaProperties,
            EntityManagerFactoryBuilder build
    ){
        return build.dataSource(dataSource)  //设置数据源
                    .properties(jpaProperties.getProperties())  //设置值jpa配置
                    .packages(BASE_ENTITY_PACKAGE)    //设置实体类管理路径
                    .persistenceUnit("primaryPersistentUnit").build();
    }

    /**
     * @param localContainerEntityManagerFactoryBean
     * @return 主数据库实体类管理对象
     */
    @Primary
    @Bean(name="primaryEntityManager")
    public EntityManager entityManager(@Qualifier("primaryEntityManagerFactory")
                                               EntityManagerFactory
                                                   localContainerEntityManagerFactoryBean){
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
