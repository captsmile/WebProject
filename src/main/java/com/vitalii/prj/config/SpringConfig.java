package com.vitalii.prj.config;

import com.vitalii.prj.dao.UserDao;
import com.vitalii.prj.dao.UserDaoImpl;
import com.vitalii.prj.service.TestBean;
import com.vitalii.prj.service.UserService;
import com.vitalii.prj.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.vitalii.prj.service","com.vitalii.prj.dao"})
//@ComponentScan(basePackages = "com.vitalii.prj.dao")
public class SpringConfig {

    @Bean
    public TestBean getTestBean(){
        return new TestBean("Hello");
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/webprj?useSll=false");
        dataSource.setPassword("");
        dataSource.setUsername("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    /*@Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }*/

    /*@Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }*/
}
