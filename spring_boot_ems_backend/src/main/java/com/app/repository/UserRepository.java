package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByuserId(int userId);
	
	public Optional<User> findByEmail(String email);

	public List<User> findByName(String name);

	public User findByEmailAndPassword(String email, String name);

	public List<User> findByActiveTrue();

	public List<User> findByAboutIsNotNull();

	public List<User> findByNameStartingWith(String prifix);

	public List<User> findByNameContaining(String infix);

	public List<User> findByNameLike(String like);

	// Createing Query Method
	@Query("select u from User u")
	public List<User> getAllUser();

}
