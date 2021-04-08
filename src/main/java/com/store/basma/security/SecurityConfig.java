package com.store.basma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=passwordEncoder();
        System.out.println("***********************");
        System.out.println(passwordEncoder.encode("1234"));
        System.out.println("***********************");
        auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("USER");
       *//* auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");*//*




    }*/
  @Autowired
  private DataSource dataSource;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=passwordEncoder();
        System.out.println("***********************");
        System.out.println(passwordEncoder.encode("user"));
        System.out.println("***********************");
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "SELECT username, encrypted_password, enable from users where username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.username, a.name " +
                                "FROM roles a, users u " +
                                "WHERE u.username = ? "
                );
    }



    /* auth
             .jdbcAuthentication()
             .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
            .usersByUsernameQuery(
                        "SELECT username, password, enabled from userss where username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.username, a.authority " +
                                "FROM user_authorities a, userss u " +
                                "WHERE u.username = ? " +
                                "AND u.id = a.user_id"
    );*/


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//
//        http.formLogin();
//        //http.authorizeRequests().antMatchers("/api/users").hasRole("ADMIN");
//        http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,"/api**/**").permitAll().anyRequest().authenticated();
//
//
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();

       /*http.authorizeRequests()
                .antMatchers("/**").hasRole("admin");*/
       http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").permitAll().anyRequest().authenticated();
                //.antMatchers("/devs/*").hasAnyRole("admin", "user")

               //.antMatchers("/api/users").hasRole("admin");


    }




        public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        }
}
