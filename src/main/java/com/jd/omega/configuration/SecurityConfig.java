package com.jd.omega.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	
	/*
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().requestMatchers(
				new AntPathRequestMatcher("/swagger-ui/**"),
				new AntPathRequestMatcher("/v3/api-docs/**")
				);

				
				}*/
	
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(new Info().title("service").description("list"));
	}
				
}
