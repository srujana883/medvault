package com.medvault.medvault.service;

import com.medvault.medvault.config.PasswordConfig;
import com.medvault.medvault.entity.User;
import com.medvault.medvault.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User saveUser(User user) {

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }
    public User findUserByEmail(String email){
        return  userRepository.findByEmail(email)
                .orElseThrow(()->new RuntimeException("user not found with email"+email));
    }
    public boolean verifyPassword(String rawPassword,String storedHash){
        return passwordEncoder.matches(rawPassword,storedHash);
    }

}
