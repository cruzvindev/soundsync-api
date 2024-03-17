package com.cruzvindev.soundsyncapi.openapi;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import java.util.Arrays;

@Configuration
public class SpringDocOpenApi {

	@Bean
	public OpenAPI soundsyncDoc() {
		return new OpenAPI()
				.info(new Info().title("Soundsync API")
						.description("Uma simples API de um app de músicas")
						.version("V1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org"))
						.contact(new Contact()
								.name("SoundSync")
								.url("https://www.soundsync.com")
								.email("contact@soundsync.com"))
				)
				.tags(Arrays.asList(
						new Tag().name("Albuns").description("Gerencia os albuns"),
						new Tag().name("Artista").description("Gerencia os artistas"),
						new Tag().name("Música").description("Gerencia as músicas")
				));
	}
}
