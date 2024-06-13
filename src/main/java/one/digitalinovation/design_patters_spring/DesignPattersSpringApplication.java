package one.digitalinovation.design_patters_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesignPattersSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPattersSpringApplication.class, args);
	}

}
