package br.cap7.petcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.cap7.petcare.repository")
@EntityScan(basePackages="br.cap7.petcare.model")
public class PetcareBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetcareBootApplication.class, args);
	}
}
