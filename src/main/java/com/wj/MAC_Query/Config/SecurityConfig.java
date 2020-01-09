package com.wj.MAC_Query.Config;


import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
//                .requestMatchers(EndpointRequest.to("health", "flyway","info")).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ENDPOINT_ADMIN")
                .and()
                .httpBasic()
        ;

        http
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll();
        http
                .headers()
                .frameOptions()
                .sameOrigin();

    }
}
