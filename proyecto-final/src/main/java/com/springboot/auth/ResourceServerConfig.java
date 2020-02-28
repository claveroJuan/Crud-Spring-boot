//package com.springboot.auth;
//
//import java.util.Arrays;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//@EnableResourceServer //dejamos disponible para habilitar las reglas de seguridad por el lado de oauth2 y jwt
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers(HttpMethod.GET, "/usuarios", "/ventas", "/**", "/images/**").permitAll()
//		/*.antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
//		.antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")
//		.antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
//		.antMatchers("/api/clientes/**").hasRole("ADMIN")*/
//		.anyRequest().authenticated()
//		.and().cors().configurationSource(corsConfigurationSource());
//	}
//	
//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() { //manejo de cors
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); //listado de origenes o dominios
//		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); //verbos permitidos
//		config.setAllowCredentials(true); //permitir las credenciales
//		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization")); //el token de authorizacion y el tipo de contenido
//		
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", config); //para todas nuestras rutas le paso la configuración del cors
//		return source;
//	}
//	
//	@Bean
//	public FilterRegistrationBean<CorsFilter> corsFilter(){
//		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
//		bean.setOrder(Ordered.HIGHEST_PRECEDENCE); //registramos el cors en el filtro con prioridad mas alta con oauth2
//		return bean;
//	}
//
//	
//}
