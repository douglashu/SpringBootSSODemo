package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableOAuth2Sso
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//  Lower order value will take precedence
//  By doing this, we make EnableOAuth2Sso related filters take precedence
//  Do not use @EnableWebSecurity here
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
//        Path '/' will not be protected by oauth
//        In this example, '/info' will be protected
//        '/info' will be redirected to auth server
        web.ignoring().antMatchers("/");
    }

}
