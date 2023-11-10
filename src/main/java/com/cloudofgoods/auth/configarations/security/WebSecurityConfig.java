package com.cloudofgoods.auth.configarations.security;

import com.cloudofgoods.auth.codeauth.CustomOAuth2User;
import com.cloudofgoods.auth.service.impl.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Slf4j
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private CustomOAuth2UserService oauth2UserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info ("LOG::WebSecurityConfig.configure(AuthenticationManagerBuilder)");
        auth.userDetailsService (userDetailsService).passwordEncoder (passwordEncoder ());
    }

    @Bean
    protected AuthenticationManager getAuthenticationManager() throws Exception {
        log.info ("LOG::WebSecurityConfig.getAuthenticationManager()");
        return super.authenticationManagerBean ();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        log.info ("LOG::WebSecurityConfig.passwordEncoder()");
        return PasswordEncoderFactories.createDelegatingPasswordEncoder ();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests ().antMatchers ("/", "/login")
//                .permitAll ()
//                .anyRequest ()
//                .authenticated ()
//                .and ().
//                formLogin ().
//                permitAll ().
//                and ().
//                oauth2Login ().
//                loginPage ("/login").
//                userInfoEndpoint ().
//                userService (oauth2UserService);
//    }
}