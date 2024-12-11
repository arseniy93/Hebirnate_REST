package com.rigin.model.dto;

import com.rigin.model.entity.User;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
@Getter
@Setter
@AllArgsConstructor
public class UserDto  {
    Long id;
    String name;
    String middleName;
    String lastName;
}