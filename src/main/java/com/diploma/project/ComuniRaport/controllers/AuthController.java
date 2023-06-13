package com.diploma.project.ComuniRaport.controllers;

import com.diploma.project.ComuniRaport.payload.request.AuthenticationRequest;
import com.diploma.project.ComuniRaport.payload.request.RegisterRequest;
import com.diploma.project.ComuniRaport.payload.response.AuthenticationResponse;
import com.diploma.project.ComuniRaport.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    )
    {
        return ResponseEntity.ok(authService.register(request));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    )
    {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException
    {
        authService.refreshToken(request, response);
    }
}
