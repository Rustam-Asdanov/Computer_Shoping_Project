package com.project.full.ComputerShoping.security;

import com.project.full.ComputerShoping.service.AccountUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.project.full.ComputerShoping.security.ApplicationPermission.COMPUTER_READ;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final AccountUserDetailsService accountUserDetailsService;

    public SecurityConfig(PasswordEncoder passwordEncoder, AccountUserDetailsService accountUserDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.accountUserDetailsService = accountUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/","/computer_shopping","/computer_shopping/*","/img/*","/css/*","/script/*").permitAll()
                .antMatchers("/computer_shopping/*")
                    .hasAuthority(COMPUTER_READ.getPermissionInfo())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/computer_shopping", true)
                .and()
                .logout()
                .logoutSuccessUrl("/computer_shopping")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getDaoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(accountUserDetailsService);
        return daoAuthenticationProvider;
    }
}
