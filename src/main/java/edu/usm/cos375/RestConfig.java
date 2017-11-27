package edu.usm.cos375;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.usm.cos375.annotation.RestAPIControllerAdvice;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"edu.usm.cos375.controller"}, useDefaultFilters=false, 
			   includeFilters= @ComponentScan.Filter({RestController.class, RestAPIControllerAdvice.class}))
public class RestConfig extends WebMvcConfigurerAdapter{

}
