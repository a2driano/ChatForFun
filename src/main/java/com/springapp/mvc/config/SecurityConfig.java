package com.springapp.mvc.config;


import com.springapp.mvc.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.AuthProvider;

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

//    @Autowired
//    AuthenticationProvider authenticationProvider;
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;


//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/img/**")
//                .antMatchers("/css/**")
//                .antMatchers("/js/**") ;
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login");
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**").access("permitAll")
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/chat").access("hasRole('ROLE_USER')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("j_username")
                .passwordParameter("j_password").permitAll()
                .and().formLogin().defaultSuccessUrl("/chat", true);
        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/chat").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login")
//                .loginProcessingUrl("/j_spring_security_check")
//                .usernameParameter("j_username")
//                .passwordParameter("j_password").permitAll().and();
//        http.logout()
//                .permitAll()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true);
//    }

//    @Autowired
//    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService);
////                .passwordEncoder(getShaPasswordEncoder());
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider)
//                        .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");
//    }
}
