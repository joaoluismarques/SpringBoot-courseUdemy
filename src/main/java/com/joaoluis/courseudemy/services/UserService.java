package com.joaoluis.courseudemy.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joaoluis.courseudemy.entities.User;
import com.joaoluis.courseudemy.repositories.UserRepository;
import com.joaoluis.courseudemy.services.exceptions.DatabaseException;
import com.joaoluis.courseudemy.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException exception) {
			throw new DatabaseException(exception.getMessage());
		}

	}

	public User update(Long id, User obj) {
		try {
		    User entity = repository.getById(id);		
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException exception) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
