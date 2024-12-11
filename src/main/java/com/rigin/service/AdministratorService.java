package com.rigin.service;

import com.rigin.administration.Administrator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AdministratorService {
    private Administrator administrator;

    public boolean isAdmin(String email, String password) {
        administrator = Administrator.getAdministrator();
        Administrator.GetFields fieldsOfAdmin = new Administrator.GetFields();
        if (fieldsOfAdmin.getEmail().equals(email) && fieldsOfAdmin.getPassword().equals(password)) {
            log.info("Enter for admin is Success ");
            return true;
        }
        log.warn("Password and/or email are wrong ");
        return false;

    }
}
