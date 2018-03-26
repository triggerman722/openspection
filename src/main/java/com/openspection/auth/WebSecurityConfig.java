package com.openspection.auth;

import com.openspection.auth.service.LinkedinSignInAdapter;
import com.openspection.auth.service.LinkedinConnectionSignup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;

@Configuration
@EnableWebSecurity
//@WebAppConfiguration
//@ComponentScan(basePackages = { "com.openspection.auth.service" })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    private UsersConnectionRepository usersConnectionRepository;

    @Autowired
    private LinkedinConnectionSignup linkedinConnectionSignup;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
@Override
@Bean
public AuthenticationManager authenticationManagerBean()
        throws Exception {
    return super.authenticationManagerBean();
}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
		.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/resources/**", "/registration", "/signin/**", "/signup/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Autowired
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
 @Bean
    // @Primary
    public ProviderSignInController providerSignInController() {
        ((InMemoryUsersConnectionRepository) usersConnectionRepository).setConnectionSignUp(linkedinConnectionSignup);
	ProviderSignInController controller = new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, new LinkedinSignInAdapter());
	controller.setApplicationUrl("http://www.codetally.com:8120");
	return controller;
	}
}
