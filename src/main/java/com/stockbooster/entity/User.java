package com.stockbooster.entity;

import com.stockbooster.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name", columnDefinition = "VARCHAR(255)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(255)")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "VARCHAR(1)")
    private Gender gender;

    @Column(name = "email", columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "phone", columnDefinition = "VARCHAR(20)")
    private String phone;

    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;
}
