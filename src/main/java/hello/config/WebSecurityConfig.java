package hello.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/database/{login}/{password}").permitAll();
        http.authorizeRequests().antMatchers("/androidShop/{login}/{pass}").permitAll();
        http.authorizeRequests().antMatchers("/buy/{id}/{login}/{pass}").permitAll();
        http.authorizeRequests().antMatchers("/timetableAndroid/{id}").permitAll();
        http.authorizeRequests().antMatchers("/getStemCoins/{teacherLogin}/{teacherPassword}/{pupilLogin}").permitAll();
        http.authorizeRequests().antMatchers("/courseGet/{login}/{password}").permitAll();
        http.authorizeRequests().antMatchers("/getTeacherCourses/{login}/{password}").permitAll();

        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance()).usersByUsernameQuery(
                "select login, password, active from usr where login=?"
        ).authoritiesByUsernameQuery(
                "select login, is_admin, is_teacher from usr where login=?");
    }
}