package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private  UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	User user = this.userRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		return user;
    
    }
}
