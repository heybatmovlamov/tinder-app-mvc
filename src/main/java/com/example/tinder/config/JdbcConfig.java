package com.example.tinder.config;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class JdbcConfig {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";
    @Bean
    @SneakyThrows
    public Connection getConnection() {
       return DriverManager.getConnection(url, user, password);
    }

}
