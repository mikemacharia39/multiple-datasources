package com.mikehenry.multipledatasources.configuration;

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
@EnableJpaRepositories(entityManagerFactoryRef = "customerEntityManagerFactory",
        basePackages = {"com.mikehenry.multipledatasources.repository.customer"},
        transactionManagerRef = "customerTransactionManager")
public class CustomerDatasourceConfiguration {

    @Primary
    @Bean(name = "customerDatasource")
    @ConfigurationProperties(prefix = "spring.customer.datasource")
    public DataSource customerDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "customerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(@Qualifier("customerDatasource") DataSource customerDatasource,
                                                                                                        EntityManagerFactoryBuilder entityManagerFactoryBuilder) {

        Map<String, String> customerJpaProperties = new HashMap<>();
        customerJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        customerJpaProperties.put("show-sql", "true");
        customerJpaProperties.put("generate-ddl", "false");
        customerJpaProperties.put("database", "mysql");

        return entityManagerFactoryBuilder
                .dataSource(customerDatasource)
                .persistenceUnit("customerDatasource")
                .properties(customerJpaProperties)
                .packages("com.mikehenry.multipledatasources.model.customer")
                .build();
    }

    @Primary
    @Bean(name = "customerTransactionManager")
    public PlatformTransactionManager customerPlatformTransactionManager(
            @Qualifier("customerEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
        return new JpaTransactionManager(customerEntityManagerFactory);
    }
}
