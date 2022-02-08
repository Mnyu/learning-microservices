package com.abhimanyutech.photoapp.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTO {
    @NotNull(message = "First Name cannot be null")
    @Size(min = 2, message = "First Name must not be less than 2 chars")
    private String firstName;

    @NotNull(message = "Last Name cannot be null")
    @Size(min = 2, message = "Last Name must not be less than 2 chars")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be between 8-16 chars(included)")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
}
