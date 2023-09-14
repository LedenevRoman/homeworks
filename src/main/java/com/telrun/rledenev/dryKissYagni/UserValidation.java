package com.telrun.rledenev.dryKissYagni;

public class UserValidation {
    public boolean validateUsername(String username) {
        return username.length() >= 6
                && username.length() <= 20
                && username.matches("^[a-zA-Z0-9]+$");

    }
    
    public boolean validateEmail(String email) {
        return email.length() >= 6
                && email.length() <= 50
                && EmailValidator.validateEmail(email);
    }
}