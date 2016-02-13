package com.springapp.mvc.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 20.01.2016
 */
@Configuration
@EnableWebMvcSecurity
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationProvider authenticationProvider;
    @Qualifier("getUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder(12));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/img/**")
                .antMatchers("/css/**")
                .antMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**").access("permitAll")
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/loginerror").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/registrationerr").permitAll()
                .antMatchers("/save").permitAll()
                .antMatchers("/chat").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/service_page").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .and().formLogin().defaultSuccessUrl("/chat", true);
        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
    }
}
