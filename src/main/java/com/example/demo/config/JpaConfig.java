package com.example.demo.config;

import com.example.demo.core.domain.IdAuditor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.example.demo.core.domain")
@EntityScan(basePackages = "com.example.demo.core.domain")
@PropertySource("application.properties")
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "idAuditor")
public class JpaConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);

        return dataSource;
    }

    @Bean
    IdAuditor idAuditor() {
        return new IdAuditor();
    }
}
