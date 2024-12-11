package com.rigin.model.dto;

import com.rigin.model.entity.Activity;
import com.rigin.model.entity.Comment;
import com.rigin.model.entity.Task;
import com.rigin.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link User}
 */
@Value
@Getter
@Setter
@AllArgsConstructor
public class UserPersonalCabinetDto implements Serializable {
    String name;
    String middleName;
    String lastName;
    String email;
    String password;
    Set<Task> tasks;
    Set<Activity> activities;
    Set<Comment> comments;
}