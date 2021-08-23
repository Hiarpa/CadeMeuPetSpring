package com.Grupo6.CadeMeuPet.config;

import com.Grupo6.CadeMeuPet.security.AuthenticationFilter;
import com.Grupo6.CadeMeuPet.security.AuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

import static com.Grupo6.CadeMeuPet.security.SecurityConstants.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.GET, FOUND_PETS_URL).permitAll()
                .antMatchers(HttpMethod.GET, LOST_PETS_URL).permitAll()
                .antMatchers(HttpMethod.GET,ALL_PETS_URL).permitAll()
                .antMatchers(AUTH_LIST).authenticated()
                .and()
                .addFilter(new AuthenticationFilter(authenticationManager()))
                .addFilter(new AuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration conf  = new CorsConfiguration().applyPermitDefaultValues();
        conf.setAllowedOriginPatterns(Collections.singletonList("http://localhost:3000"));
        conf.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        conf.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        conf.setExposedHeaders(Arrays.asList("Authorization", "content-type","token"));
        conf.setAllowedHeaders(Arrays.asList("Authorization", "content-type", "token"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", conf);
        return source;
    }

}
