package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("controller")
@Import(AppConfig.class)

public class WebConfig {

	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver=new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		//on fixe que les vues utilisent les jsp avec la jstl
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}	
	
	public WebConfig() {
		System.out.println("le server fonctionne");
	}
	
}
