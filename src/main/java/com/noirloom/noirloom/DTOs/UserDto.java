package com.noirloom.noirloom.DTOs;

import com.noirloom.noirloom.Enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
        private Long id;

        @NotNull @NotBlank(message = "User must have a name")
        private String name;

        @NotNull @NotBlank(message = "user's e-mail is missing")
        private String email;

        @NotNull @NotBlank(message = "The password is missing")
        private String password;

        private String nationality;
        private String gender;

        @NotBlank @NotNull(message = "User's role is not registered")
        private UserRole role;
    }

