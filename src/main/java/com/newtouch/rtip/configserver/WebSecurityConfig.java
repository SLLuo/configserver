package com.newtouch.rtip.configserver;

import com.newtouch.rtip.configserver.security.CustomFilterSecurityInterceptor;
import com.newtouch.rtip.configserver.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomFilterSecurityInterceptor customFilterSecurityInterceptor;

    @Bean
    public UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
                .and().rememberMe().key("CS_SESSION_ID").tokenValiditySeconds(60 * 60 * 24 * 7)
                .and().logout().logoutUrl("/custom-logout").logoutSuccessUrl("/login").permitAll();
        http.addFilterBefore(customFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/2.35/**");
    }
}