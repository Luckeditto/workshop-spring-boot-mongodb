package com.lucasaraujo.workshopmongo.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasaraujo.workshopmongo.domain.User;
import com.lucasaraujo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	private final UserRepository userRepository;
	
	public Instantiation(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		
	}

}
