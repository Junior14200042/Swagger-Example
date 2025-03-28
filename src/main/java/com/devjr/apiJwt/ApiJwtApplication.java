package com.devjr.apiJwt;

import com.devjr.apiJwt.model.Role;
import com.devjr.apiJwt.model.RoleEnum;
import com.devjr.apiJwt.model.UserEntity;
import com.devjr.apiJwt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ApiJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJwtApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner init(PasswordEncoder passwordEncoder, UserRepository userRepository){
		return args->{

			Role roleAdmin = Role.builder()
					.name(RoleEnum.ADMIN)
					.build();

			Role roleUser= Role.builder()
					.name(RoleEnum.USER)
					.build();

			UserEntity userAdmin = UserEntity.builder()
					.username("junior")
					.email("juniorc14200042@gmail.com")
					.password(passwordEncoder.encode("1234"))
					.creationDate(LocalDateTime.now())
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity user = UserEntity.builder()
					.username("kevin")
					.email("kevin.canari@gmail.com")
					.password(passwordEncoder.encode("5678"))
					.creationDate(LocalDateTime.now())
					.roles(Set.of(roleUser))
					.build();


			userRepository.saveAll(List.of(user,userAdmin));

		};
	}*/

}
