package pe.edu.vallegrande.ms_infraestructura.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;


/**
 * Configuración global de CORS - ACCESO UNIVERSAL
 * Esta configuración permite el acceso desde cualquier origen web
 * Configuración actualizada para máxima compatibilidad y acceso abierto
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // Permitir cualquier origen (acceso universal)
        corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));

        // Permitir cualquier método HTTP
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","PATCH","OPTIONS"));

        // Permitir cualquier header
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));

        corsConfiguration.setExposedHeaders(Arrays.asList(
                "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials",
                "Authorization", "Content-Disposition", "X-Total-Count",
                "X-Page-Number", "X-Page-Size"));

        // Nota: Al usar allowCredentials=true con origins="*", se deben usar
        // allowedOriginPatterns
        // Para acceso completamente abierto, se podría cambiar a allowCredentials=false
        // No permitir credenciales para acceso universal
        corsConfiguration.setAllowCredentials(false);

        corsConfiguration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }
}

