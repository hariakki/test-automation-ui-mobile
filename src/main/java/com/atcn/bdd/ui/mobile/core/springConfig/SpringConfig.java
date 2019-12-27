package com.atcn.bdd.ui.mobile.core.springConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:mobileConfig.properties")
@ComponentScan(basePackages = {"com.atcn.bdd.ui.mobile.*"})
@EnableAutoConfiguration
public class SpringConfig {
}

