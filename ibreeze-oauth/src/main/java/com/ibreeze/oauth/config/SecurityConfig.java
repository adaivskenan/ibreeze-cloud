package com.ibreeze.oauth.config;

import com.ibreeze.oauth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private UserService userService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //认证用户的来源【内存、数据库】

    //配置springSecurity相关信息
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //org.springframework.security.core.userdetails.User.UserBuilder.roles()
//       auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER");
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").hasAnyRole("USER","ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .successForwardUrl("/index")
                .failureForwardUrl("/failure")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .permitAll();
    }



}
