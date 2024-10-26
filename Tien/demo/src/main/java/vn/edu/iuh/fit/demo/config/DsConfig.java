package vn.edu.iuh.fit.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DsConfig {

    @Bean
    @Scope("singleton")
    public DataSource mariadbDataSource() throws Throwable {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://localhost:3306/demo?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("sapassword");
        return dataSource;
    }
}
