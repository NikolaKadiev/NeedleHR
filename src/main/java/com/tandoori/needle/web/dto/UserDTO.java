package com.tandoori.needle.web.dto;

import com.tandoori.needle.service.validators.PasswordMatches;
import com.tandoori.needle.service.validators.UniqueEmail;
import com.tandoori.needle.service.validators.ValidEmail;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@PasswordMatches
public class UserDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String password;
    @NotBlank
    private String matchingPassword;
    @NotBlank
    @ValidEmail
    @UniqueEmail
    private String email;
}
