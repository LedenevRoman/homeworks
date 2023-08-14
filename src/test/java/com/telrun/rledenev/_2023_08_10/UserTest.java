package com.telrun.rledenev._2023_08_10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static final Role ROLE_A = new Role(1, "A-name", "A-description");
    private static final Role ROLE_B = new Role(2, "B-name", "B-description");
    private static final Role ROLE_C = new Role(3, "C-name", "C-description");
    private static final String EMAIL = "email@test.com";
    private static final String USERNAME_A = "A-username";
    private static final String PASSWORD_A = "p@ssword1";
    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1, USERNAME_A, EMAIL, new ArrayList<>(), PASSWORD_A, true);
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    void addRolePositiveCaseTest() {
        assertTrue(user.addRole(ROLE_A));
        assertTrue(user.addRole(ROLE_B));
        assertTrue(user.addRole(ROLE_C));
        List<Role> expected = List.of(ROLE_A, ROLE_B, ROLE_C);
        assertEquals(expected, user.getRoles());
    }

    @Test
    void addRoleNegativeCaseTest() {
        assertFalse(user.addRole(null));
    }

    @Test
    void removeRolePositiveCaseTest() {
        assertTrue(user.addRole(ROLE_A));
        assertTrue(user.addRole(ROLE_B));
        assertTrue(user.removeRole(ROLE_A));
        assertTrue(user.removeRole(ROLE_B));
        assertEquals(new ArrayList<>(), user.getRoles());
    }

    @Test
    void removeRoleNegativeCaseTest() {
        assertTrue(user.addRole(ROLE_A));
        assertTrue(user.addRole(ROLE_B));
        assertFalse(user.removeRole(ROLE_C));
        assertEquals(List.of(ROLE_A, ROLE_B), user.getRoles());
    }
}