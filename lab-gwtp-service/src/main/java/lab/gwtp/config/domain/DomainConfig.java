package lab.gwtp.config.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lab.gwtp.domain.LabGwtpDomainPackage;

@Configuration
@ComponentScan(basePackageClasses = { LabGwtpDomainPackage.class })
public class DomainConfig {
}