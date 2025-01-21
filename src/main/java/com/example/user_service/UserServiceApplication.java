package com.example.user_service;

import com.example.user_service.models.RolType;
import com.example.user_service.models.UserEntity;
import com.example.user_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class UserServiceApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(){
		return args -> {
			UserEntity admin = new UserEntity("admin", "admin@gmail.com");
			admin.setRole(RolType.ADMIN);
			userRepository.saveAll(Set.of(admin, new UserEntity("Juan", "juan@gmail.com"), new UserEntity("katy", "katy@hotmail.com")));
		};
	}
}
