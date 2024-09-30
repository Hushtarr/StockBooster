package com.stockbooster.dto;

import com.stockbooster.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private String email;

    private String phone;

    private String password;
}
