package prc391.common.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
//        web.ignoring().antMatchers("prc391/api/login");
        web.ignoring().anyRequest();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http.cors().and().csrf();
    }
}
