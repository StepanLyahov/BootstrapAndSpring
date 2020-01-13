package com.kurosv.mysite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/home", "/registration").permitAll() // тут мы пришем url, которые доступны всем (для всех остальных нам нужна авторизация)
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login") // тут указываем, что мы используем форму для авторизаци и говорим, как у неё путь
                    .permitAll() // говорим, что она доступна для всех
                .and()
                    .logout()
                    .permitAll(); // как я понялдаём возможность, чтобы разлогиниться и тоже даём общий доступ

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?");
    }



    /*
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
     */
}
