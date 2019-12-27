package com.atcn.bdd.ui.mobile.core.springConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.atcn.bdd.ui.mobile.*"})
@PropertySource("classpath:mobileConfig.properties")
@EnableAutoConfiguration
public class SpringConfig {
}

