package com.abhimanyutech.photoapp.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseTO {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
