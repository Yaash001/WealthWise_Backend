package com.wealthfitness.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean //it define CORS spring boot
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://127.0.0.1:3306/wealthy") //url of mysql
                .username("root")   //username
                .password("Radhika653")     //password for user
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
