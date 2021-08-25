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
    public  static final String BASE_REPOSITORY_PACKAGE = "com.wei.multidatasource.second.repository";
    public  static final String BASE_ENTITY_PACKAGE     = "com.wei.multidatasource.second.entity";

    /**
     * @return   第二数据源jpa配置
     */

    @Bean(name = "secondJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.second")
    public JpaProperties jpaProperties(){
        return new JpaProperties();
    }

    /**
     * @param dataSource
     * @param jpaProperties
     * @param build
     * @return 第二数据库实体管理工厂
     */

    @Bean(name = "secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean(
            @Qualifier("secondDatasource") DataSource dataSource,
            @Qualifier("secondJpaProperties") JpaProperties jpaProperties,
            EntityManagerFactoryBuilder build
    ){
        return build.dataSource(dataSource)  //设置数据源
                .properties(jpaProperties.getProperties())  //设置值jpa配置
                .packages(BASE_ENTITY_PACKAGE)    //设置实体类管理路径
                .persistenceUnit("secondPersistentUnit").build();
    }

    /**
     * @param localContainerEntityManagerFactoryBean
     * @return 第二数据库实体类管理对象
     */

    @Bean(name="secondEntityManager")
    public EntityManager entityManager(@Qualifier("secondEntityManagerFactory")
                                               EntityManagerFactory
                                               localContainerEntityManagerFactoryBean){
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
