package com.telrun.rledenev._2023_08_10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
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
    private static final User USER_B_NO_ACCESS = new User(2, USERNAME_B, "b.user@gmail.com",
            new ArrayList<>(Arrays.asList(ROLE_B, ROLE_C)), PASSWORD_B, false);
    private static final User USER_C = new User(3, USERNAME_C, "c.user@gmail.com",
            new ArrayList<>(Arrays.asList(ROLE_A, ROLE_C)), PASSWORD_C, true);
    private static final List<User> USERS = new ArrayList<>(Arrays.asList(USER_A, USER_B_NO_ACCESS, USER_C));
    private AuthenticationService authenticationService;
    private UserDatabase userDatabase;

    @BeforeEach
    void setUp() {
        USER_A.setHasAccess(true);
        USER_C.setHasAccess(true);
        USER_B_NO_ACCESS.setHasAccess(false);
        userDatabase = new UserDatabase(USERS);
        authenticationService = new AuthenticationService(userDatabase);
    }

    @AfterEach
    void tearDown() {
        authenticationService = null;
        userDatabase = null;
    }

    @Test
    void authenticatePositiveCaseTest() {
        assertTrue(authenticationService.authenticate(USERNAME_A, PASSWORD_A));
        assertTrue(authenticationService.authenticate(USERNAME_B, PASSWORD_B));
        assertTrue(authenticationService.authenticate(USERNAME_C, PASSWORD_C));
    }

    @Test
    void authenticateNegativeCaseTest() {
        assertFalse(authenticationService.authenticate(USERNAME_A, PASSWORD_B));
        assertFalse(authenticationService.authenticate(USERNAME_B, PASSWORD_C));
        assertFalse(authenticationService.authenticate(null, PASSWORD_B));
        assertFalse(authenticationService.authenticate(USERNAME_C, null));
        assertFalse(authenticationService.authenticate(null, null));
    }

    @Test
    void grantAccessPositiveCaseTest() {
        assertFalse(USER_B_NO_ACCESS.isHasAccess());
        authenticationService.grantAccess(USER_B_NO_ACCESS);
        assertTrue(USER_B_NO_ACCESS.isHasAccess());
    }

    @Test
    void grantAccessNegativeCaseTest() {
        assertThrows(IllegalArgumentException.class, () -> authenticationService.grantAccess(null));
    }

    @Test
    void revokeAccessPositiveCaseTest() {
        assertTrue(USER_A.isHasAccess());
        assertTrue(USER_C.isHasAccess());
        authenticationService.revokeAccess(USER_A);
        authenticationService.revokeAccess(USER_C);
        assertFalse(USER_A.isHasAccess());
        assertFalse(USER_C.isHasAccess());
    }

    @Test
    void revokeAccessNegativeCaseTest() {
        assertThrows(IllegalArgumentException.class, () -> authenticationService.revokeAccess(null));
    }
}