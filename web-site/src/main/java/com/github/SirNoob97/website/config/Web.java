package com.github.SirNoob97.website.config;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
public class Web implements ApplicationContextAware, WebMvcConfigurer {

  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.setPatternParser(new PathPatternParser()).addPathPrefix("/",
        HandlerTypePredicate.forAnnotation(Controller.class));
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/img/**", "/css/**", "/js/**")
            .addResourceLocations("classpath:/static/img/", "classpath:/static/css/", "classpath:/static/js/");
  }

  @Bean
  public SpringResourceTemplateResolver templateResolver() {
    var resolver = new SpringResourceTemplateResolver();
    resolver.setApplicationContext(applicationContext);
    resolver.setPrefix("classpath:/templates/");
    resolver.setSuffix(".html");
    resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
    return resolver;
  }

  @Bean
  public SpringTemplateEngine templateEngine() {
    var engine = new SpringTemplateEngine();
    engine.setTemplateResolver(templateResolver());
    return engine;
  }

  @Bean
  public ThymeleafViewResolver viewResolver() {
    var resolver = new ThymeleafViewResolver();
    resolver.setTemplateEngine(templateEngine());
    return resolver;
  }
}
