package com.tren.huantai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


    @Configuration
//此处是你dao文件所在的包名
    @EnableJpaRepositories("com.tren.huantai.repository.base")
    @EnableTransactionManagement
    public class JpaConfig {
        @Autowired
        private DataSource dataSource;
        @Autowired
        private ApplicationProperties applicationProperties;
        @Bean
        public EntityManagerFactory entityManagerFactory() {
            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
            factory.setJpaVendorAdapter(vendorAdapter);
            //此处com.example.*.model是你的java bean所在的包名
            factory.setPackagesToScan("com.tren.huantai.*.entity");
            factory.setDataSource(dataSource);
            Map<String, Object> jpaProperties = new HashMap<>();
            jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
            jpaProperties.put("hibernate.jdbc.batch_size", 50);
            //自动创建表
            jpaProperties.put("hibernate.hbm2ddl.auto", applicationProperties.getIsCreateTable());
            //是否打印sql执行语句
            jpaProperties.put("hibernate.show_sql",applicationProperties.isShowSql());
            factory.setJpaPropertyMap(jpaProperties);
            factory.afterPropertiesSet();
            return factory.getObject();
        }
        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager txManager = new JpaTransactionManager();
            txManager.setEntityManagerFactory(entityManagerFactory());
            return txManager;
        }
    }


