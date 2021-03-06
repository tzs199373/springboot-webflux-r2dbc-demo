package com.example.webflux.config;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DatabaseClient;

@Configuration
public class R2dbc_mysql {
    @Bean(name = "mySqlConnectionFactory")
    public ConnectionFactory connectionFactory() {
        return MySqlConnectionFactory.from(MySqlConnectionConfiguration.builder()
                .host("127.0.0.1")
                .port(3306)
                .username("root")
                .password("accp")
                .database("test")
                .build());
    }

    @Bean
    public DatabaseClient databaseClient(@Qualifier("mySqlConnectionFactory") @Autowired ConnectionFactory connectionFactory) {
        return DatabaseClient.create(connectionFactory);
    }





}
