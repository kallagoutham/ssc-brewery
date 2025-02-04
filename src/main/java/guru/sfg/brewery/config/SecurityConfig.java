package guru.sfg.brewery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity) ((HttpSecurity) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)
                http
                        .authorizeRequests(authorize->{
                            authorize
                                    .antMatchers("/","/webjars/**").permitAll()
                                    .antMatchers(HttpMethod.GET,"api/v1/beer/**").permitAll();
                        })
                        .authorizeRequests()
                        .anyRequest())
                .authenticated()
                .and())
                .formLogin()
                .and())
                .httpBasic();
    }
}
