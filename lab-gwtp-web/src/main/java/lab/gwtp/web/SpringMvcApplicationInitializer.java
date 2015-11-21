package lab.gwtp.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lab.gwtp.domain.config.DomainConfig;
import lab.gwtp.rest.config.RestConfig;

public class SpringMvcApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { DomainConfig.class };
  }

  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { RestConfig.class };
  }

  protected String[] getServletMappings() {
    return new String[] { RestConfig.URI_PATTERN };
  }

}
