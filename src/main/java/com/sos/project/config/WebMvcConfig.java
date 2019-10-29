package com.sos.project.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;



@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class WebMvcConfig implements WebMvcConfigurer {
	
	private String url;
	private String jdbcUrl;
	private String username;
	private String password;
	private String driverClassName;
	private boolean testWhileIdle;
	

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean(name = "datasource")
    @Primary
    public DataSource createDataSource() {
    	DataSourceBuilder <HikariDataSource> dataSourceBuilder = (DataSourceBuilder <HikariDataSource>)DataSourceBuilder.create();
     	HikariDataSource datasource = dataSourceBuilder.build();
    	datasource.setJdbcUrl(jdbcUrl);
    	datasource.setUsername(username);
    	datasource.setPassword(password);
    	datasource.setDriverClassName(driverClassName);
       return datasource;
    }

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getJdbcUrl()
	{
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl)
	{
		this.jdbcUrl = jdbcUrl;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getDriverClassName()
	{
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName)
	{
		this.driverClassName = driverClassName;
	}

	public boolean isTestWhileIdle()
	{
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle)
	{
		this.testWhileIdle = testWhileIdle;
	}
 
}