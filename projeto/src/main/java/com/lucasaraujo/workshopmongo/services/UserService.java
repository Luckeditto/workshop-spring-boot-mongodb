package com.lucasaraujo.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasaraujo.workshopmongo.domain.User;
import com.lucasaraujo.workshopmongo.dto.UserDTO;
import com.lucasaraujo.workshopmongo.repository.UserRepository;
import com.lucasaraujo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		try {
		Optional<User> newUser = repo.findById(obj.getId());
		User user = newUser.orElseThrow();
		updateData(user, obj);
		return repo.save(user);
		} catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
	}
	
	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		
	}
}
