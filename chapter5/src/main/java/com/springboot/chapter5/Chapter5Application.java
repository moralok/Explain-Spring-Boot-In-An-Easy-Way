package com.springboot.chapter5;

import com.springboot.chapter5.dao.MyBatisUserDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

// 定义 Spring Boot 的扫描包路径
@SpringBootApplication(scanBasePackages = {"com.springboot.chapter5"})
// 定义 JPA 接口扫描包路径
@EnableJpaRepositories(basePackages = "com.springboot.chapter5.dao")
// 定义实体 Bean 扫描包路径
@EntityScan(basePackages = "com.springboot.chapter5.pojo")
// 定义 MyBatis 扫描
@MapperScan(
        // 指定扫描包
        basePackages = "com.springboot.chapter5.*",
        // 指定 SqlSessionFactory，如果 sqlSessionTemplate 被指定，则作废
        sqlSessionFactoryRef = "sqlSessionFactory",
        // 指定 sqlSessionFactory，将忽略 sqlSessionFactory 的配置
        sqlSessionTemplateRef = "sqlSessionTemplate",
        // 限定扫描接口，不常用
        // markerInterface = Class.class,
        annotationClass = Repository.class

)
public class Chapter5Application {

    @Autowired
    SqlSessionFactory sqlSessionFactory = null;

    // 定义一个MyBatis 的 Mapper 接口
//    @Bean
//    public MapperFactoryBean<MyBatisUserDao> initMyBatisUserDao() {
//        MapperFactoryBean<MyBatisUserDao> bean = new MapperFactoryBean<>();
//        bean.setMapperInterface(MyBatisUserDao.class);
//        bean.setSqlSessionFactory(sqlSessionFactory);
//        return bean;
//    }

    /**
     * 配置 MyBatis 接口扫描
     * @return 返回扫描器
     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        // 定义扫描器实例
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        // 加载 SqlSessionFactory，Spring Boot 会自动生成，SqlSessionFactory 实例
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        // 定义扫描的包
//        mapperScannerConfigurer.setBasePackage("com.springboot.chapter5.*");
//        // 限定被标注 @Repository 的接口才被扫描
//        mapperScannerConfigurer.setAnnotationClass(Repository.class);
//        // 通过继承某个接口限制扫描，一般使用不多
//        // mapperScannerConfigurer.setMarkerInterface(……);
//        return mapperScannerConfigurer;
//    }


    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class, args);
    }

}
