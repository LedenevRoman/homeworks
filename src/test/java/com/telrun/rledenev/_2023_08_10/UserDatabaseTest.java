package com.telrun.rledenev._2023_08_10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserDatabaseTest {
    private static final Role ROLE_A = new Role(1, "A-name", "A-description");
    private static final Role ROLE_B = new Role(2, "B-name", "B-description");
    private static final Role ROLE_C = new Role(3, "C-name", "C-description");
    private static final String USERNAME_A = "A-username";
    private static final String USERNAME_B = "B-username";
    private static final String USERNAME_C = "C-username";
    private static final String PASSWORD_A = "p@ssword1";
    private static final String PASSWORD_B = "p@ssword2";
    private static final String PASSWORD_C = "p@ssword3";
    private static final User USER_A = new User(1, USERNAME_A, "a.user@gmail.com",
            new ArrayList<>(Arrays.asList(ROLE_A, ROLE_B)), PASSWORD_A, true);
    private static final User USER_B = new User(2, USERNAME_B, "b.user@gmail.com",
            new ArrayList<>(Arrays.asList(ROLE_B, ROLE_C)), PASSWORD_B, false);
    private static final User USER_C = new User(3, USERNAME_C, "c.user@gmail.com",
            new ArrayList<>(Arrays.asList(ROLE_A, ROLE_C)), PASSWORD_C, true);
    private UserDatabase userDatabase;

    @BeforeEach
    void setUp() {
        userDatabase = new UserDatabase(new ArrayList<>());
        userDatabase.addUser(USER_A);
        userDatabase.addUser(USER_B);
        userDatabase.addUser(USER_C);
    }

    @AfterEach
    void tearDown() {
        userDatabase = null;
    }

    @Test
    void getUserByIdPositiveCaseTest() {
        assertEquals(USER_A, userDatabase.getUserById(1));
        assertEquals(USER_B, userDatabase.getUserById(2));
        assertEquals(USER_C, userDatabase.getUserById(3));
    }

    @Test
    void getUserByIdNegativeCaseTest() {
        assertThrows(NoSuchUserException.class, () -> userDatabase.getUserById(-1));
        assertThrows(NoSuchUserException.class, () -> userDatabase.getUserById(10));
    }

    @Test
    void getUserByUsernamePositiveCaseTest() {
        assertEquals(USER_A, userDatabase.getUserByUsername(USERNAME_A));
        assertEquals(USER_B, userDatabase.getUserByUsername(USERNAME_B));
        assertEquals(USER_C, userDatabase.getUserByUsername(USERNAME_C));
    }

    @Test
    void getUserByUsernameNegativeCaseTest() {
        assertThrows(NoSuchUserException.class, () -> userDatabase.getUserByUsername(null));
        assertThrows(NoSuchUserException.class, () -> userDatabase.getUserByUsername("-1"));
        assertThrows(NoSuchUserException.class, () -> userDatabase.getUserByUsername("Aloha"));
    }

    @Test
    void addUserNegativeCaseTest() {
        assertFalse(userDatabase.addUser(null));
    }
}