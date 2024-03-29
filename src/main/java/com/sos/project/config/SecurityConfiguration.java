package com.sos.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;


	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/access-denied").permitAll()
			.antMatchers("/rest/**").permitAll()
			.antMatchers("/error").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/public/**").permitAll()
			.antMatchers("/webjars/**").permitAll()
			.antMatchers("/rest/public/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login").defaultSuccessUrl("/home", false)
			.failureForwardUrl("/error")
			.loginProcessingUrl("/performlogin")
			.failureUrl("/error")
			.usernameParameter("username")
            .passwordParameter("password")
            .and().logout()
            .logoutUrl("/performlogout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/home").and().exceptionHandling()
            .accessDeniedPage("/access-denied");

	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth)
    throws Exception {
        auth
        	.jdbcAuthentication()
            .usersByUsernameQuery(usersQuery)
            .authoritiesByUsernameQuery(rolesQuery)
            .dataSource(dataSource)
            .passwordEncoder(bCryptPasswordEncoder);
    }

	@Override
    public void configure(WebSecurity web) {
        web
        	.ignoring()
            .antMatchers("/css/**", "/script/**", "/images/**", "/webjars/**");
    }

}
