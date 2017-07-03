package com.adme.dry.configuration;

import com.adme.dry.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * Created by Adme System on 6/14/2017.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(value="myAccessDeniedHandler")
    MyAccessDeniedHandler accessDeniedHandler;

    @Autowired
    @Qualifier(value="myAuthenticationProvider")
    MyAuthenticationProvider myAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity security) throws Exception{
        security.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login","/about","/assets/**","/assets/fonts/**","/assets/font-awesome/**","/assets/css/**","/assets/js/**","/assets/img/**","/vendor/**").permitAll().anyRequest().fullyAuthenticated()

                .and()
                    .formLogin()
                    .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myAuthenticationProvider);
    }

}
