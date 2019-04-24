package com.zft.securityinaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Description: 安全配置类
 * @author  fengtan.zhang
 * @date    2019/4/24 0024 上午 10:11
 * @email   fengtan_zhang@sina.com
 * @version 1.0
 */
@Configuration
@EnableWebSecurity //启用security
public class SecurityConfig extends WebSecurityConfigurerAdapter{



    /**
     * 自定义配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() //都可以访问
                .antMatchers("/users/**").hasRole("ADMIN") // 需要相应的角色才可以访问
                .and()
                .formLogin() //基于form表单登录验证
                .loginPage("/login").failureUrl("/login-error").defaultSuccessUrl("/users/list"); //自定义登录页面

    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN").and();
        //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
    }
}
