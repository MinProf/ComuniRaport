package com.diploma.project.ComuniRaport.payload.request;


import com.diploma.project.ComuniRaport.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String city;
    private String county;
    private ERole eRole;
}
