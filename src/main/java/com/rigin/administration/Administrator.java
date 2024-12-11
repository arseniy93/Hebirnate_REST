package com.rigin.administration;

import lombok.Getter;


public class Administrator {
    public static class GetFields {
        @Getter
        private String email = Administrator.getEmail();
        @Getter
        private String password = Administrator.getPassword();

    }

    private static Administrator administrator;
    @Getter
    private static String email;
    @Getter
    private static String password;

    private Administrator() {
        Administrator.email = "anton";
        Administrator.password = "anton";

    }

    public static synchronized Administrator getAdministrator() {
        if (administrator == null) {
            administrator = new Administrator();
        }
        return administrator;
    }

}