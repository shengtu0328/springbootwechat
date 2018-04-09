package com.example.demo.config.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.example.demo.dao")
public class DataSoureConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.jdbcurl}")
    private String jdbcUrl;
    @Value("${jdbc.jdbcusername}")
    private String jdbcusername;
    @Value("${jdbc.jdbcpassword}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource= new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcusername);
        dataSource.setPassword(jdbcPassword);
        //关闭连接不自动提交
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
