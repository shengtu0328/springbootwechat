package com.example.demo.config.dao;

import org.springframework.context.annotation.Bean;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

public class DataSoureConfiguration {

    private String jdbcDriver;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource= new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbausername);
        dataSource.setPassword(jdbcPassword);
        //关闭连接不自动提交
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
