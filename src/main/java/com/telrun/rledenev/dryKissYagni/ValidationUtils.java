package com.telrun.rledenev.dryKissYagni;

public class ValidationUtils {
    private static final String EMAIL_REGEXP = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$";
    private static final Integer PHONE_NUMBER_LENGTH = 10;
    public boolean isEmailValid(String email) {
        return email.matches(EMAIL_REGEXP);
    }
    
    public boolean isPhoneNumberValid(String phoneNumber) {
        String digitsOnly = phoneNumber.replaceAll("\\D", "");
        return digitsOnly.length() == PHONE_NUMBER_LENGTH
                && phoneNumber.startsWith("+1");
    }
    
    public boolean isPasswordValid(String password) {
        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[!@#$%].*")
                && !password.contains(" ");
    }
}