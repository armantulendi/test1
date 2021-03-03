package com.example.multiconnect6_test.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "userEntityManagerFactory",
        basePackages = {"com.example.multiconnect6_test.user.repository"},
        transactionManagerRef = "userTransactionManager"
        )
public class UserDBConfig {
    @Primary
    @Bean(name = "userDatasource")
    @ConfigurationProperties(prefix ="spring.user.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
    @Primary
    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("userDatasource") DataSource dataSource){
        Map<String,Object> properties=new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto","create");
        return builder.dataSource(dataSource).properties(properties)
                .packages("com.example.multiconnect6_test.model.user").persistenceUnit("User").build();
    }
    @Primary
    @Bean(name = "userTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("userEntityManagerFactory")
           EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
