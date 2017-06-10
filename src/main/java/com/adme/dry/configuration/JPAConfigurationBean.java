package com.adme.dry.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Adme System on 12/1/2016.
 */
@ComponentScan(basePackages = {"com.adme.dry.services","com.adme.dry.repository"})
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",basePackages = {"com.adme.dry.repository"})
@EntityScan("com.adme.dry.entities")
public class JPAConfigurationBean {
    @Bean(name="dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,@Qualifier("dataSource") DataSource dataSource){
        LocalContainerEntityManagerFactoryBean mg=builder.dataSource(dataSource)
                .packages("com.adme.dry.entities")
                .persistenceUnit("dry")
                .build();
        mg.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        mg.setJpaProperties(this.additionalProperties());
        return mg;
    }
    @Primary
    @Bean(name="transactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager=new JpaTransactionManager(entityManagerFactory);
        jpaTransactionManager.setJpaDialect(new HibernateJpaDialect());
        return jpaTransactionManager;
    }

    public Properties additionalProperties(){
        Properties properties=new Properties();
        properties.setProperty("hibernate.hbm2dl.auto","none");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.SQLServer2008Dialect");
        properties.setProperty("hibernate.show_sql","none");
        return  properties;
    }
}
