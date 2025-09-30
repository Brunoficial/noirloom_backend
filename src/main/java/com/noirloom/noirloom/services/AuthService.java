package com.noirloom.noirloom.services;

import com.noirloom.noirloom.DTOs.AuthDto;
import com.noirloom.noirloom.DTOs.LoginResponseDto;
import com.noirloom.noirloom.DTOs.RegisterDto;
import com.noirloom.noirloom.infra.security.TokenService;
import com.noirloom.noirloom.models.CartModel;
import com.noirloom.noirloom.models.UserModel;
import com.noirloom.noirloom.repositories.CartRepository;
import com.noirloom.noirloom.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.remote.JMXAuthenticator;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity register(RegisterDto data) {
        if (this.userRepository.findByEmail(data.getEmail()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        UserModel newUser = new UserModel(data.getName() ,data.getEmail(), encryptedPassword, data.getRole());

        this.userRepository.save(newUser);

        CartModel newCart = new CartModel();
        newCart.setUser(newUser);

        this.cartRepository.save(newCart);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity login (AuthDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
