package com.example.EmployeeManagementSystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SecondaryDataSourceConfig {

    @Bean
    @Qualifier("secondaryDataSource")
    public DataSource secondaryDataSource(DataSourceProperties properties) {
        DriverManagerDataSource dSrc = new DriverManagerDataSource();
        dSrc.setDriverClassName(properties.getDriverClassName());
        dSrc.setUrl(properties.getUrl());
        dSrc.setUsername(properties.getUsername());
        dSrc.setPassword(properties.getPassword());
        return dSrc;
    }
}
