package com.yorranpetrick.forumhub.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// Habilita o suporte à segurança na aplicação Spring Boot
@EnableWebSecurity
@Configuration
public class Securityconfiguration {

    // Este bean define toda a configuração de segurança HTTP da aplicação
    @Bean
    private SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Configura a autorização das requisições HTTP
        http.authorizeHttpRequests(authorize ->
                        // anyRequest().authenticated() -> qualquer requisição precisa estar autenticada
                        authorize.anyRequest().authenticated())

                // Desativa a proteção CSRF (Cross-Site Request Forgery)
                // Isso geralmente é feito em APIs REST que não usam cookies para autenticação
                .csrf(csrf -> csrf.disable())

                // Configura o servidor de recursos para usar autenticação via JWT (OAuth2)
                // Customizer.withDefaults() -> usa as configurações padrão
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))

                // Define a política de criação de sessão
                // STATELESS -> não mantém estado de sessão no servidor (importante para APIs REST)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Retorna o objeto configurado para o Spring usar na proteção da aplicação
        return http.build();
    }
}
