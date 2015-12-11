package lab.gwtp.config.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lab.gwtp.rest.LabGwtpRestPackage;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = { LabGwtpRestPackage.class })
public class RestConfig extends WebMvcConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestConfig.class);

	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		LOGGER.debug("Configurando os conversores de mensagem do Spring MVC.");
		for (HttpMessageConverter<?> converter : converters) {
			if (converter instanceof MappingJackson2HttpMessageConverter) {
				configurarConversorMensagemJackson(converter);
				break;
			}
		}
		LOGGER.debug("Conversores de mensagem do Spring MVC configurados.");
	}

	private void configurarConversorMensagemJackson(HttpMessageConverter<?> converter) {
		LOGGER.debug("Configurando o Jackson.");
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = (MappingJackson2HttpMessageConverter) converter;
		ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();
		LOGGER.debug("Configurando data no Jackson.");
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		LOGGER.debug("Data no Jackson configurada.");
		LOGGER.debug("Jackson configurado.");
	}
}