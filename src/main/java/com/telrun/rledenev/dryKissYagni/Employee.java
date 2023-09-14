package com.telrun.rledenev.dryKissYagni;

public class Employee {
    private static final String DOMAIN_NAME = "company.com";
    private final String firstName;
    private final String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
    
    public String getInitials() {
        return String.format("%c.%c.", firstName.charAt(0), lastName.charAt(0)).toUpperCase();
    }

    public String getEmail() {
        return String.format("%s.%s@%s", firstName, lastName, DOMAIN_NAME).toLowerCase();
    }
}