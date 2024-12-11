package com.rigin.model.dto;

import lombok.*;

@Value
@Setter
@Builder
@ToString
public class UserSignInDto {
    @Setter(AccessLevel.NONE)
    Long id;
    String name;
    String middleName;
    String lastName;
    String email;
    String password;
}
