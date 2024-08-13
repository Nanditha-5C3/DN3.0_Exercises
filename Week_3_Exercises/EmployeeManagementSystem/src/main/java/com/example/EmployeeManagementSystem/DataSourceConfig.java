package com.example.EmployeeManagementSystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    @Qualifier("primaryDataSource")
    public DataSource primaryDataSource(DataSourceProperties prprts) {
        DriverManagerDataSource dSrc = new DriverManagerDataSource();
        dSrc.setDriverClassName(prprts.getDriverClassName());
        dSrc.setUrl(prprts.getUrl());
        dSrc.setUsername(prprts.getUsername());
        dSrc.setPassword(prprts.getPassword());
        return dSrc;
    }

}
