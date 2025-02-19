package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.app.security.*;
import com.app.dto.JwtRequest;
import com.app.dto.JwtResponse;
import com.app.dto.UserDto;
import com.app.security.JwtHelper;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtHelper jwtHelper;
    
    @Autowired
    private ModelMapper model;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        authenticateUser(request.getUsername(), request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtHelper.generateToken(userDetails);

        JwtResponse response = new JwtResponse();
        response.setToken(token);
        response.setUser(this.fromUserDetails(userDetails));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
    
    private UserDto fromUserDetails(UserDetails userDetails) {
		return null;
        // Implement the conversion from UserDetails to your UserDto
        // Example: return new UserDto(userDetails.getUsername(), ...);
    }
    

    private void authenticateUser(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            LOGGER.info("User '{}' successfully authenticated.", username);
        }
        catch (BadCredentialsException e) {
            LOGGER.error("Invalid username or password for user '{}'", username);
//            throw new InvalidCredentialsException("Invalid username or password");
//        } catch (DisabledException e) {
//            LOGGER.error("User '{}' is not active", username);
//            throw new UserNotActiveException("User is not active");
        }
    }
}
