package com.mobiquity.tests;

import com.mobiquity.domains.clients.UsersClient;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Smoke")
@DisplayName("Mobiquity Test Cases")
@ExtendWith(TestListener.class)
public class Mobiquity_Test {

    private final UsersClient usersClient;


    public Mobiquity_Test() {
        usersClient = new UsersClient();
    }

    @Test
    @Tag("GET")
    @DisplayName("GET User with Username")
    @Description("GET User with Username = Delphine and see its existence")
    public void getUser() {
        assertNotNull(usersClient.getUserWithUsername("Delphine"));
    }

    @Test
    @Tag("POST")
    @DisplayName("POST A User")
    @Description("POST A new user and check whether a new id is generated")
    public void postUser() {
        assertTrue(usersClient.postUser() > usersClient.getLatestUserId());
    }
}