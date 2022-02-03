package br.org.generation.blogpessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@SpringBootApplication
public class BlogpessoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogpessoalApplication.class, args);
	}

@GetMapping
public ModelAndView swaggerUi () {
		
	return new ModelAndView("redirect:/swagger-ui/");
	}
}
