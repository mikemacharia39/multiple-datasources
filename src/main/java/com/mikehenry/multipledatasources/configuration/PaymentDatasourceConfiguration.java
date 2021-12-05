package com.mikehenry.multipledatasources.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(basePackages = {"com.mikehenry.multipledatasources.repository.payment"},
        entityManagerFactoryRef = "paymentEntityManagerFactory",
        transactionManagerRef = "paymentTransactionManager")
public class PaymentDatasourceConfiguration {

    @Bean(name = "paymentDatasource")
    @ConfigurationProperties(prefix = "spring.payment.datasource")
    public DataSource paymentDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "paymentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean paymentEntityManagerFactory(@Qualifier("paymentDatasource") DataSource paymentDatasource,
                                                                              EntityManagerFactoryBuilder entityManagerFactoryBuilder) {

        Map<String, String> paymentJpaProperties = new HashMap<>();
        paymentJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        paymentJpaProperties.put("show-sql", "true");
        paymentJpaProperties.put("generate-ddl", "false");
        paymentJpaProperties.put("database", "mysql");

        return entityManagerFactoryBuilder
                .dataSource(paymentDatasource)
                .packages("com.mikehenry.multipledatasources.model.payment")
                .properties(paymentJpaProperties)
                .persistenceUnit("paymentDatasource")
                .build();
    }


    public PlatformTransactionManager paymentTransactionManager(
            @Qualifier("paymentEntityManagerFactory") EntityManagerFactory paymentEntityManagerFactory) {
        return new JpaTransactionManager(paymentEntityManagerFactory);
    }
}
