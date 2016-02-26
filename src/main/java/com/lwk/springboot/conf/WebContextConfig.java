package com.lwk.springboot.conf;

import com.lwk.springboot.commandLineRunner.StartupRunner;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 类似于spring-context.xml或者beans.xml
 * MapperScan用于扫描Mapper映射接口，比如本例中的 UserDao
 * MapperScan、ComponentScan具体的使用方法 跟之前的ComponentScan 完全相同 此处便不再赘述
 */
@Configuration
@MapperScan(basePackages = "com.lwk.springboot.dao")
@ComponentScan(basePackages = "com.lwk.springboot")
public class WebContextConfig {

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
//        数据库连接配置
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

//    事务管理
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(getDataSource());
        return sqlSessionFactory.getObject();
    }

    @Bean
    public StartupRunner schedulerRunner() {
        return new StartupRunner();
    }
}