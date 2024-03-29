package com.github.vlsidlyarevich.config;

import com.github.vlsidlyarevich.security.filter.AuthenticationTokenFilter;
import com.github.vlsidlyarevich.security.service.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    protected SecurityConfig(final TokenAuthenticationService tokenAuthenticationService) {
        super();
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/auth").permitAll()
                .antMatchers("/api/signup").permitAll()
                .antMatchers("/api/users").permitAll()
                .antMatchers("/api/users/{email}/password").permitAll()
                .antMatchers("/api/users/{email}/email").permitAll()
                .antMatchers("/api/carts").permitAll()
                .antMatchers("/api/carts/{id}").permitAll()
                .antMatchers("/api/carts/{id}/ticket").permitAll()
                .antMatchers("/api/movies").permitAll()
                .antMatchers("/api/movies/{id}").permitAll()
                .antMatchers("/api/reservations").permitAll()
                .antMatchers("/api/reservations/{id}/status").permitAll()
                .antMatchers("/api/showtimes").permitAll()
                .antMatchers("/api/showtimes/{id}").permitAll()
                .antMatchers("/api/showtimes/theaters/{id}").permitAll()
                .antMatchers("/api/showtimes/movies/{id}").permitAll()
                .antMatchers("/api/showtimes/{id}/status").permitAll()
                .antMatchers("/api/theaters").permitAll()
                .antMatchers("/api/theaters/{id}").permitAll()
                .antMatchers("/api/hello").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new AuthenticationTokenFilter(tokenAuthenticationService),
                        UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();
    }
}
