package com.kurosv.mysite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/home").permitAll() // тут мы пришем url, которые доступны всем (для всех остальных нам нужна авторизация)
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login") // тут указываем, что мы используем форму для авторизаци и говорим, как у неё путь
                    .permitAll() // говорим, что она доступна для всех
                .and()
                    .logout()
                    .permitAll(); // как я понялдаём возможность, чтобы разлогиниться и тоже даём общий доступ

    }

    // шо це такое. хз. Но, что я понял, тут мы добавляем только одного авторизованного пользователя. Это нужно только для тестирования.
    // в дальнейшем у нас будет логика авторизации.
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
