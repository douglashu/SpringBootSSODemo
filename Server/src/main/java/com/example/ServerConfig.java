package com.example;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by paulzhang on 7/04/2017.
 */
@Configuration
public class ServerConfig {

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//    Lower order value will take precedence
//    By doing this, we make authentication server related filters and resource server related server filters take precedence.
//    Do not use @EnableWebSecurity here
    protected static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll().and().csrf().disable();
        }
    }


    @Configuration
    @EnableResourceServer
//    Resource server is used to retrieve user related info (such as current user) and provide REST API
    protected static class ResourceConfig extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/user").authorizeRequests().anyRequest().authenticated();
        }
    }
}
