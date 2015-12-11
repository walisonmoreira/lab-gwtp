package lab.gwtp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lab.gwtp.config.domain.DomainConfig;
import lab.gwtp.config.security.SecurityConfig;

@Configuration
@Import({ DomainConfig.class, SecurityConfig.class })
public class RootConfig {
}
