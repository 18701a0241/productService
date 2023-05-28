package org.ass.productservice.util;


import java.util.Properties;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class SessionFactoryUtil {
		
		@Bean
		public 	LocalSessionFactoryBean getSessionFactory() {
			LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
			sessionFactoryBean.setDataSource(getDataSource());
			sessionFactoryBean.setHibernateProperties(getMyDbProperties());
			sessionFactoryBean.setPackagesToScan("org.ass.productservice.entity");
			return sessionFactoryBean;
			
		}

		public static Properties getMyDbProperties() {
			Properties properties = new Properties();
			properties.setProperty("hibernate.show_sql", "true");
			//properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			properties.setProperty("hibernate.hbm2ddl.auto","update");
			
			return properties;
			}
		@Bean
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/config_db");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			return dataSource;
			}		
	}
