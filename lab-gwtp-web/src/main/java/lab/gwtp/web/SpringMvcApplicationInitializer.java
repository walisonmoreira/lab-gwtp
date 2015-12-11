package lab.gwtp.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lab.gwtp.config.RootConfig;
import lab.gwtp.config.rest.RestConfig;
import lab.gwtp.shared.ResourcePaths;

public class SpringMvcApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { RestConfig.class };
	}

	protected String[] getServletMappings() {
		return new String[] { ResourcePaths.ROOT + "/*" };
	}
}
