package com.ig.springboot;

import com.ig.springboot.hello.DevBean;
import com.ig.springboot.hello.HelloService;
import com.ig.springboot.hello.IgProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootApplication {

	@Autowired
	private HelloService helloService;

	//@Autowired
	//private DevBean devBean;

	//Third-party Configuration인 경우
	@ConfigurationProperties(prefix = "ig")
	@Validated
	@Bean
	public IgProperties anotherComponent() {
		return new IgProperties();
	}

	@GetMapping("/")
	public String home() {
		System.out.println(anotherComponent().getWorkFor());
		System.out.println(anotherComponent().getWhereToGo());
		System.out.println(anotherComponent().getFooBar());
		System.out.println(anotherComponent().getTime1());
		System.out.println(anotherComponent().getTime2());
		System.out.println(anotherComponent().getTime3());
		return helloService.getMessage();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringbootApplication.class);

		app.setWebApplicationType(WebApplicationType.SERVLET);
		app.setApplicationStartup(new BufferingApplicationStartup(2048));
		app.run(args);




		//System.exit(app.exit(run));
	}

}
