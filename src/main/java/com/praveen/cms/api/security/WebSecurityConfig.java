package com.praveen.cms.api.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtUserDetailService jwtUserDetailService;
    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    private final Logger logger = LogManager.getLogger(getClass().getName());

    public WebSecurityConfig(JwtUserDetailService jwtUserDetailService) {
        this.jwtUserDetailService = jwtUserDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("\n\n::: Security Step 1::: "+getClass().getName()+"\n\n");
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        auth.userDetailsService(jwtUserDetailService).passwordEncoder(passwordEncoder());
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("\n\n :::Security Step 2:::"+getClass().getName()+"\n\n");
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/cms/customer/signup",
                                                "/cms/customer/signin")
                .permitAll()
                .antMatchers(HttpMethod.GET,"/cms/customer/search")
                .permitAll()
                .anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                // use stateless session; session won't be used to
                // store user's state.
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add our filter to validate the tokens with every request
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        logger.info("\n\n :::Security Step ignore request:::"+getClass().getName()+"\n\n");
        web.ignoring().antMatchers( "/v2/api-docs","/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**");
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
