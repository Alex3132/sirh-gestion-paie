package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class HerokuDBConfig {

    @Bean
    public DataSource dataSource() throws URISyntaxException {

        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = "postgres";
        String password = "Caline32=!";
        String dbUrl = "jdbc:postgresql://127.0.0.1:5432/sirh-paie";


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

}