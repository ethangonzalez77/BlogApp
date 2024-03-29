package com.codeup.blogapp;

import com.codeup.blogapp.services.UserDetailsLoader;
import com.codeup.blogapp.services.UserDetailsLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//which pages are available to who
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(usersLoader) // How to find users by their username
//                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
//        ;
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/posts") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page
                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // append a query string value
                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/", "/posts", "/sign-up") // anyone can see the home and the ads pages
                .permitAll()
                /* Pages that require authentication */
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/posts/create",
                        "/posts/{id}/edit",// only authenticated users can create ads
                        "/posts/{id}"
                )
                .authenticated()
        ;
        return http.build();

    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                /* Login configuration */
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/ads") // user's home page, it can be any URL
//                .permitAll() // Anyone can go to the login page
//                /* Logout configuration */
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login?logout") // append a query string value
//                /* Pages that can be viewed without having to log in */
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/", "/ads") // anyone can see the home and the ads pages
//                .permitAll()//anyone ayuthorized to make the request
//                /* Pages that require authentication */
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers(
//                        "/ads/create", // only authenticated users can create ads
//                        "/ads/{id}/edit" // only authenticated users can edit ads
//                )
//                .authenticated()
//        ; return http.build();
//    }




}
