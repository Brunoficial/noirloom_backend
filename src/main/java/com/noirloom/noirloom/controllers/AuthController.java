package com.noirloom.noirloom.controllers;

import com.noirloom.noirloom.DTOs.AuthDto;
import com.noirloom.noirloom.DTOs.LoginResponseDto;
import com.noirloom.noirloom.DTOs.RegisterDto;
import com.noirloom.noirloom.infra.security.TokenService;
import com.noirloom.noirloom.models.CartModel;
import com.noirloom.noirloom.models.UserModel;
import com.noirloom.noirloom.repositories.CartRepository;
import com.noirloom.noirloom.repositories.UserRepository;
import com.noirloom.noirloom.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AuthDto data) {
        return authService.login(data);
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody @Valid RegisterDto data ) {
        return authService.register(data);
    }
}
