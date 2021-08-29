package com.openwebinars.secondhandmarket.seguridad;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SeguridadConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/", "/webjars/**", "/css/**", "/h2-console/**", "/public/**", "/auth/**", "/files/**")
                    .permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/auth/login")
                    .defaultSuccessUrl("/public/index", true)
                    .loginProcessingUrl("/auth/login-post")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/auth/logout")
                    .logoutSuccessUrl("/public/index");

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
