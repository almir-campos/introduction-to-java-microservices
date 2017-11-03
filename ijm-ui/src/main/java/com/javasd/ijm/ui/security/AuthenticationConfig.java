/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.ui.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author acampos
 */
@Configuration
public class AuthenticationConfig
        extends WebSecurityConfigurerAdapter {
    
   // User
    @Value("${users.regular.username}")
    private String user_username;
    @Value("${users.regular.password}")
    private String user_password;
    @Value("${users.regular.role}")
    private String user_role;
    
    // Admin
    @Value("${users.admin.username}")
    private String admin_username;
    @Value("${users.admin.password}")
    private String admin_password;
    @Value("${users.admin.role}")
    private String admin_role;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(user_username)
                .password(user_password)
                .roles(user_role.toUpperCase())
                .and()
                .withUser(admin_username)
                .password(admin_password)
                .roles(admin_role.toUpperCase());
    }
}
