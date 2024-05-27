package br.com.fiap.sos_tera.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private VerifyToken verifyToken;

  @Bean
  public SecurityFilterChain filterChainSecurity(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.POST, "/auth/login")
                    .permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/cadastro")
                    .permitAll()
                    .requestMatchers(HttpMethod.POST, "/usuarios/cadastrar")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/usuarios/excluir/")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/usuarios/atualizar")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/usuarios")
                    .hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.GET, "/usuarios/id/perfil")
                    .hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.POST, "/alertas/cadastrar")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/alertas/excluir/")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/alertas/atualizar")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/alertas")
                    .hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.GET, "/alertas/id")
                    .hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.POST, "/locais/cadastrar")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/locais/excluir/")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/locais/atualizar")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/locais")
                    .hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.GET, "/locais/id")
                    .hasAnyRole("ADMIN", "USER")
                    .anyRequest()
                    .authenticated()
            )
            .addFilterBefore(
                    verifyToken,
                    UsernamePasswordAuthenticationFilter.class
            )
            .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}