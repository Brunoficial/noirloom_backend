package com.noirloom.noirloom.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
        private Long id;
        private String name;
        private String email;
        private String password;
        private String nationality;
        private String gender;
        private String userType;
    }

