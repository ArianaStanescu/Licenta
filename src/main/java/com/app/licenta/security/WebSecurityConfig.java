package com.app.licenta.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;
import java.util.Objects;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@ConditionalOnProperty(name = "authorization.enabled", havingValue = "true")
public class WebSecurityConfig {

    private static final String TRAINER_ROLE = "trainer";
    private static final String PARENT_ROLE = "parent";
    private final JwtAuthConverter jwtAuthConverter;

    public WebSecurityConfig(JwtAuthConverter jwtAuthConverter) {
        super();
        this.jwtAuthConverter = jwtAuthConverter;
    }

    @Bean
    public HttpFirewall getHttpFirewall() {
        return new DefaultHttpFirewall();

//		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
//		strictHttpFirewall.setAllowSemicolon(true);
//		return strictHttpFirewall;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                //.cors(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                        .requestMatchers("/trainers/register", "/error", "/parents/register")
                        .permitAll()
                        .requestMatchers("/**")
                        .hasAnyRole(TRAINER_ROLE, PARENT_ROLE)
                        .anyRequest()
                        .authenticated());


        http.oauth2ResourceServer(oAuth2ResourceServerConfigurer -> oAuth2ResourceServerConfigurer.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthConverter)));
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Origin", "Content-Type", "Accept", "Authorization"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
