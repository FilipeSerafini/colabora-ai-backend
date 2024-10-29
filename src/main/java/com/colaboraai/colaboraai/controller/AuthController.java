package com.colaboraai.colaboraai.controller;

import com.colaboraai.colaboraai.Model.Admin;  
import com.colaboraai.colaboraai.config.Security.JwtTokenUtil;
import com.colaboraai.colaboraai.Service.AuthService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Admin admin) throws Exception {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(admin.getUsername(), admin.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Usuário ou senha incorretos"));
        }

        final UserDetails userDetails = authService.loadUserByUsername(admin.getUsername());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(Map.of(
            "message", "Login feito com sucesso",
            "token", jwtToken
        ));
    }
}
