package com.diploma.project.ComuniRaport;

import com.diploma.project.ComuniRaport.payload.request.RegisterRequest;
import com.diploma.project.ComuniRaport.services.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.diploma.project.ComuniRaport.enums.ERole.ADMIN;
import static com.diploma.project.ComuniRaport.enums.ERole.MANAGER;


@SpringBootApplication
public class ComuniRaportApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ComuniRaportApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthService service
	)
	{
		return args -> {
			var admin = RegisterRequest.builder()
					.firstName("Admin")
					.lastName("Admin")
					.email("admin@mail.com")
					.password("password")
					.phone("x")
					.city("x")
					.county("x")
//                .eRole(ERole.USER)
					.eRole(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstName("Manager")
					.lastName("Manager")
					.email("manager@mail.com")
					.password("password")
					.phone("x")
					.city("x")
					.county("x")
//                .eRole(ERole.USER)
					.eRole(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());
		};
	}
}
