package com.hrsystem.userapi;

import com.hrsystem.userapi.domain.User;
import com.hrsystem.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class UserApiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new User(null, "Jose Carlos", "josecarlos@gmail.com", "123", 20.0),
				new User(null, "Carlos Roberto", "carlosroberto@gmail.com", "123", 30.0),
				new User(null, "Roberto Monteiro", "robertomonteiro@gmail.com", "123", 50.0),
				new User(null, "Marcos Andre", "marcosandre@gmail.com", "123", 60.0)
		));
	}
}
