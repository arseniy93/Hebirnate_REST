package com.rigin.service;

import com.rigin.model.dto.UserLogInDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class LogInServer {

    private final UserService userService;

    public Optional<UserLogInDto> getUserByPasswordAndEmail(String email, String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }


}
