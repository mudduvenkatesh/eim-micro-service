package net.trigyan.glide;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableAutoConfiguration
public class EimMicroServiceApplication  {

	@Value("${graphdb.server.url}")
	String graphDBServer;
	
	
	@RequestMapping("/")
	public String home() {
		return "Hello World from Spring boot and Semantic Web Glide by Trigyan running on " + graphDBServer;
	}
	public static void main(String[] args) {
		SpringApplication.run(EimMicroServiceApplication.class, args);
	}
}
