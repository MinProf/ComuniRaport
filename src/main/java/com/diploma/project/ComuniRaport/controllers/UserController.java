package com.diploma.project.ComuniRaport.controllers;


import com.diploma.project.ComuniRaport.models.User;
import com.diploma.project.ComuniRaport.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserDetails> getUser(@RequestBody String username){
        return ResponseEntity.ok(userService.loadUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity<String> editUser(@RequestBody User user){
        return ResponseEntity.ok(userService.editUser(user));
    }

    @PostMapping("password")
    public ResponseEntity<String> updatePassword(@RequestBody String username, @RequestBody String currentPassword, @RequestBody String newPassword){
        return ResponseEntity.ok(userService.updatePassword(username, currentPassword, newPassword));
    }

}
