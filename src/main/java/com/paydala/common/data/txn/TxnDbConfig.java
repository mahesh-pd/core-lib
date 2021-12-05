package com.paydala.common.data.txn;

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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "txnEntityManagerFactory",
        transactionManagerRef = "txnTransactionManager",
        basePackages = {"com.paydala.common.data.txn.access"}
)
public class TxnDbConfig {

    @Bean(name = "txnDataSource")
    @ConfigurationProperties(prefix = "txn.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "txnEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    txnEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("txnDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.paydala.common.data.txn.entity")
                .persistenceUnit("txn")
                .build();
    }

    @Bean(name = "txnTransactionManager")
    public PlatformTransactionManager txnTransactionManager(
            @Qualifier("txnEntityManagerFactory") EntityManagerFactory
                    txnEntityManagerFactory
    ) {
        return new JpaTransactionManager(txnEntityManagerFactory);
    }
}
