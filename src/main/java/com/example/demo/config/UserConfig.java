package com.example.demo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class UserConfig {
	@Bean
	public javax.validation.Validator validator() {
	    final LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
	    factory.setValidationMessageSource(messageSource());
	    return factory;
	}

	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasenames("classpath:/demo/src/main/resources/validation.properties");
	    messageSource.setUseCodeAsDefaultMessage(false);
	    messageSource.setCacheSeconds((int) TimeUnit.HOURS.toSeconds(1));
	    messageSource.setFallbackToSystemLocale(false);
	    return messageSource;
	}



}
