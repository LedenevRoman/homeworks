package com.telrun.rledenev.dryKissYagni;

public class EmailValidator {
    private static final String EMAIL_REGEXP = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$";
    public static boolean validateEmail(String email) {
        return email.matches(EMAIL_REGEXP);
    }
}
