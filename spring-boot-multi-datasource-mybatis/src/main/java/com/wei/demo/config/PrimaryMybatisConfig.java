package com.wei.demo.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Configuration
@MapperScan(basePackages ={"com.wei.demo.primary.mapper"},
        sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryMybatisConfig {

    private  static  final List<String> MAPPER_LOCATION= Arrays.asList("classpath:mapper-primary/*Mapper.xml");

    @Primary
    @Bean("primarySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean= new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(PrimaryMybatisConfig.getResources());
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean("primarySqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    public static Resource[] getResources() throws IOException {
        List<Resource> paths= new ArrayList<>();
        for (String s : PrimaryMybatisConfig.MAPPER_LOCATION) {
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources(s);

            for (Resource resource : resources) {
                paths.add(resource);
            }
        }

        Resource[] res = new Resource[paths.size()];
        for (int i = 0; i <paths.size() ; i++) {
            res[i]=paths.get(i);
        }
        return res;
    }
}
