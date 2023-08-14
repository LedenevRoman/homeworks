package com.telrun.rledenev._2023_08_10;

import java.util.List;
import java.util.Objects;

public class UserDatabase {
    private final List<User> users;

    public UserDatabase(List<User> users) {
        this.users = users;
    }

    public User getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchUserException("User not found with id = " + id));
    }

    public User getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new NoSuchUserException("User not found with username = " + username));
    }

    public boolean addUser(User user) {
        if (user == null) {
            return false;
        }
        return users.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDatabase that = (UserDatabase) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "UserDatabase{" +
                "users=" + users +
                '}';
    }
}
