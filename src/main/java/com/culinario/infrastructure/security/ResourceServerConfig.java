package com.culinario.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ResourceServerConfig {

    final String ADMIN = "ADMIN";
    final String USER = "USER";

    @Autowired
    private JwtDecoder jwtDecoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
                        .requestMatchers("/user/me/**").hasRole(USER)
                        .requestMatchers(HttpMethod.GET, "/dishes/**").hasRole(USER)
                        .requestMatchers("/dishes/**").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/ingredients/**").hasRole(USER)
                        .requestMatchers("/ingredients/**").hasRole(ADMIN)
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt
                        .decoder(jwtDecoder)
                        .jwtAuthenticationConverter(jwtAuthenticationConverter())
                ));

        return http.build();
    }

    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            List<String> userRoleAuthorities = jwt.getClaimAsStringList("authorities");

            if (userRoleAuthorities == null) {
                return Collections.emptyList();
            }

            JwtGrantedAuthoritiesConverter scopesConverter = new JwtGrantedAuthoritiesConverter();

            Collection<GrantedAuthority> scopeAuthorities = scopesConverter.convert(jwt);

            scopeAuthorities.addAll(userRoleAuthorities.stream().map(SimpleGrantedAuthority::new).toList());

            return scopeAuthorities;
        });

        return converter;
    }

}
