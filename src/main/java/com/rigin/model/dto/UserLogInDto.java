package com.rigin.model.dto;

import lombok.*;

@Value
@Getter
@Setter
@AllArgsConstructor
public class UserLogInDto {
    Long id;
    String email;
    String password;
}
