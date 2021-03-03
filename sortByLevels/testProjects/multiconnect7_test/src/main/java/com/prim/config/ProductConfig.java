package com.prim.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages =  "com.prim.dao.product",
        entityManagerFactoryRef = "productEntityManager",
        transactionManagerRef = "productTransactionManager")
public class ProductConfig {

    @Bean
    @ConfigurationProperties(prefix="main.db")
    public DataSource productDataSource() {
        return DataSourceBuilder.create().build();
    }

    // productEntityManager bean 
    @Bean(name = "productEntityManager")
    public LocalContainerEntityManagerFactoryBean mainEntityManager(EntityManagerFactoryBuilder builder){
         return builder
                 .dataSource(productDataSource())
                 .persistenceUnit("productUnit")
//                 .packages(Product.class)
                 .build();
    }
    // productTransactionManager bean
    @Primary
    @Bean(name = "productTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("productEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}