package com.prim.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration

@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "com.prim.dao.user",
        entityManagerFactoryRef = "userEntityManager",
        transactionManagerRef = "userTransactionManager")
public class UserConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix="second.db")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }
    // userEntityManager bean
    @Primary
    @Bean(name = "userEntityManager")
    public LocalContainerEntityManagerFactoryBean mainEntityManager(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(userDataSource())
                .persistenceUnit("userUnit")
//                .packages(User.class)
                .build();
    }
    // userTransactionManager bean
    @Primary
    @Bean(name = "userTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("userEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}