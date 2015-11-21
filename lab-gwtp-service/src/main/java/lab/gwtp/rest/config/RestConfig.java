package lab.gwtp.rest.config;

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

@Configuration
@ComponentScan(basePackageClasses = { LabGwtpRestPackage.class })
@EnableWebMvc
public class RestConfig extends WebMvcConfigurerAdapter {

  private static final Logger log = LoggerFactory.getLogger(RestConfig.class);

  public static final String URI_PATTERN = "/rest/*";

  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    log.debug("Configurando os conversores de mensagem do Spring MVC.");
    for (HttpMessageConverter<?> converter : converters) {
      if (converter instanceof MappingJackson2HttpMessageConverter) {
        configurarConversorMensagemJackson(converter);
        break;
      }
    }
    log.debug("Conversores de mesagem do Spring MVC configurados.");
  }

  private void configurarConversorMensagemJackson(HttpMessageConverter<?> converter) {
    log.debug("Configurando o Jackson.");
    MappingJackson2HttpMessageConverter jsonMessageConverter = (MappingJackson2HttpMessageConverter) converter;
    ObjectMapper objectMapper = jsonMessageConverter.getObjectMapper();
    log.debug("Configurando data no Jackson.");
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    log.debug("Data no Jackson configurada.");
    log.debug("Jackson configurado.");
  }
}