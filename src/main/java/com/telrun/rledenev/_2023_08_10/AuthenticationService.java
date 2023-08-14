package com.telrun.rledenev._2023_08_10;

import java.util.Objects;

public class AuthenticationService {
    private final UserDatabase userDatabase;

    public AuthenticationService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean authenticate(String username, String password) {
        User user;
        try {
            user = userDatabase.getUserByUsername(username);
        } catch (NoSuchUserException exception) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    public void grantAccess(User user) {
        checkNull(user);
        user.setHasAccess(true);
    }

    public void revokeAccess(User user) {
        checkNull(user);
        user.setHasAccess(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationService that = (AuthenticationService) o;
        return Objects.equals(userDatabase, that.userDatabase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDatabase);
    }

    @Override
    public String toString() {
        return "AuthenticationService{" +
                "userDatabase=" + userDatabase +
                '}';
    }

    private static void checkNull(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }
    }
}
