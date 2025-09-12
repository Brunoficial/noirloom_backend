package com.noirloom.noirloom.DTOs;

import com.noirloom.noirloom.Enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    @NotNull
    @NotBlank(message = "User must have a name!")
    String name;

    @Email
    @NotNull
    @NotBlank(message = "User must have an e-mail!")
    String email;

    @NotNull
    @NotBlank(message = "A password must be inserted!")
    String password;

    @NotNull(message = "User's role not described")
    UserRole role;
}
