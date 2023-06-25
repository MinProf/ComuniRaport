package com.diploma.project.ComuniRaport.services;

import com.diploma.project.ComuniRaport.models.User;
import com.diploma.project.ComuniRaport.payload.response.UserInfoResponse;
import com.diploma.project.ComuniRaport.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return userRepository.findByEmail(username).orElseThrow();
    }

    public String editUser(User user)
    {
        var userOptional = userRepository.findByEmail(user.getEmail());
        if(!userOptional.isPresent())
        {
            return "User not found";
        }

        var userEdited = User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .city(user.getCity())
                .county(user.getCounty())
                .build();

        userRepository.save(userEdited);
        return "User updated";
    }

    public String updatePassword(String username, String currentPassword, String newPassword)
    {
        var userOptional = userRepository.findByEmail(username);
        if(!userOptional.isPresent())
        {
            return "User not found";
        }
        var databaseUser = userOptional.orElseThrow();
        userRepository.updatePassword(passwordEncoder.encode(newPassword), username);
        return "Password updated";
    }
}
