package com.example.Config;

import com.example.Service.UserService;
import com.example.Service.impl.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomSuccessHandler CustomSuccessHandler;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ServiceLayer serviceLayer;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/","/login","/register");
            http.authorizeRequests().antMatchers("/store/**").hasAuthority("ROLE_OWNER");
            http.authorizeRequests().antMatchers("/staff").hasAnyAuthority("ROLE_STAFF","ROLE_OWNER");
            http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")
                .successHandler(CustomSuccessHandler)
                .failureUrl("/login?error=true")//
                .usernameParameter("phone")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.tokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
        http.csrf().disable();
    }

    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(serviceLayer).passwordEncoder(passwordEncoder());

    }
}
