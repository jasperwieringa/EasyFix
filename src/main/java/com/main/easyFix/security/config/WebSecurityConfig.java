package com.main.easyFix.security.config;

import com.main.easyFix.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final AppUserService appUserService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers(
          "/js/**",
          "/css/**",
          "/webjars/**"
        ).permitAll()
        .antMatchers("/h2-console/**").permitAll()
        .anyRequest().authenticated()
      .and()
        .formLogin()
          .loginPage("/login")
        .permitAll()
      .and()
        .logout()
          .invalidateHttpSession(true)
          .clearAuthentication(true)
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
          .logoutSuccessUrl("/login?logout")
        .permitAll();
      http.csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // Setup default employee accounts
    auth.inMemoryAuthentication()
      .withUser("admin@easyfix.nl").password(bCryptPasswordEncoder.encode("EasyFixAdminLogin"))
      .roles("ADMIN");
    auth.inMemoryAuthentication()
      .withUser("expert@easyfix.nl").password(bCryptPasswordEncoder.encode("EasyFixExpertLogin"))
      .roles("EXPERT");
    auth.inMemoryAuthentication()
      .withUser("cashier@easyfix.nl").password(bCryptPasswordEncoder.encode("EasyFixCashierLogin"))
      .roles("CASHIER");
    auth.inMemoryAuthentication()
      .withUser("backoffice@easyfix.nl").password(bCryptPasswordEncoder.encode("EasyFixBackofficeLogin"))
      .roles("BACKOFFICE");

    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
      .ignoring()
      .antMatchers("/h2-console/**");
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(bCryptPasswordEncoder);
    provider.setUserDetailsService(appUserService);
    return provider;
  }

  @Bean
  public SpringSecurityDialect springSecurityDialect(){
    return new SpringSecurityDialect();
  }
}
