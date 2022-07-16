package com.github.salemalawi.medicallaboratory.config;

import com.github.salemalawi.medicallaboratory.security.JwtTokenProvider;
import com.github.salemalawi.medicallaboratory.security.TokenAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
public class SecurityConfig {


    @Bean
    public ReactiveAuthenticationManager authenticationManager() {
        return new ReactiveAuthenticationManager() {
            @Override
            public Mono<Authentication> authenticate(Authentication authentication) {
                return Mono.empty();
            }
        };
    }

    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http, JwtTokenProvider tokenProvider){

        return http.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(ae->{
                    ae.anyExchange().permitAll();
                })
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(new TokenAuthenticationFilter(tokenProvider), SecurityWebFiltersOrder.HTTP_BASIC)
                .build();
    }


}
