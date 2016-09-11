package pl.java.scalatech.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/customer/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/customer").hasRole("USER")
                .antMatchers("/news/**").hasRole("ADMIN")
                .antMatchers("/about", "/contact","/github/page/**").permitAll()
                .antMatchers("/", "/js/**", "/login/**", "/css/**", "/img/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .ignoringAntMatchers("/admin/h2-console/*")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .headers()
.frameOptions().sameOrigin();
    }
 // @formatter:on
}


