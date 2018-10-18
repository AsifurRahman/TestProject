package com.mbstu.ehcare.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/vendor/**").permitAll()
                .antMatchers("/iCheck/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/brequest").permitAll()
                .antMatchers("/admin/preAuthorized/**").permitAll()
                .antMatchers("/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                //.loginPage("/landingpage").permitAll()
                //.loginPage("/brequest").permitAll()
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .csrf().disable();
    }
}
