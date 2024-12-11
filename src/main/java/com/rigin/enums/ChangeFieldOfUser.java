package com.rigin.enums;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public enum ChangeFieldOfUser {
    NAME("name"),
    LAST_NAME("lastName"),
    MIDDLE_NAME("middleName"),
    EMAIL("email"),
    PASSWORD("password");



    private String nameOfField;


}
