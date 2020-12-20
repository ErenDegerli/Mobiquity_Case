package com.mobiquity.tests;

import com.mobiquity.domains.clients.CommentsClient;
import com.mobiquity.domains.clients.PostClient;
import com.mobiquity.domains.clients.UsersClient;
import com.mobiquity.domains.response.UsersResponse.UsersResponse;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Smoke")
@DisplayName("Mobiquity Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestListener.class)
public class Mobiquity_Test {

    private final UsersClient usersClient;
    private final PostClient postClient;
    private final CommentsClient commentsClient;
    private final String name;


    public Mobiquity_Test() {
        usersClient = new UsersClient();
        postClient = new PostClient();
        commentsClient = new CommentsClient();
        name = "Delphine";
    }

    @Test
    @Tag("GET")
    @DisplayName("GET User with Username")
    @Description("GET User with Username = Delphine and see its existence")
    public void getUser() {
        UsersResponse response = usersClient.getUserWithUsername(name);
        assertAll(
                () -> assertNotNull(response),
                () -> assertEquals("Glenna Reichert",response.getName()),
                () -> assertEquals("Chaim_McDermott@dana.io", response.getEmail())
        );
    }

    @Test
    @Order(1)
    @Tag("POST")
    @DisplayName("POST A User")
    @Description("POST A new user and check whether a new id is generated")
    public void postUser() {
        assertTrue(usersClient.postUser() > usersClient.getLatestUserId());
    }

    @Test
    @Tag("GET")
    @DisplayName("GET Post IDs of a User")
    @Description("GET Post IDs of Username Delphine")
    public void getPostIDs() {
        assertTrue(postClient.getPostIdsOfAUser(usersClient.getUserWithUsername(name).getId()).size() > 0);
    }

    @Test
    @Tag("GET")
    @DisplayName("GET Invalid Email Number")
    @Description("GET Emails from Delphine's Posts and check their format")
    public void checkEmailFormat() {
        assertEquals(0, commentsClient.getNumberOfInvalidEmailsFromPostComments(
                postClient.getPostIdsOfAUser(
                        usersClient.getUserWithUsername(name).getId())));
    }

    @Test
    @Order(1)
    @Tag("DELETE")
    @DisplayName("DELETE User")
    @Description("DELETE A User with ID = 5 and get Success Code")
    public void deleteUser() {
        assertTrue(usersClient.deleteUser(5));
    }

    @Test
    @Order(2)
    @Tag("GET")
    @DisplayName("GET Deleted User")
    @Description("GET Deleted User, in the step above, and expect Status Code NOT to be 200")
    public void getDeletedUser() {
        assertFalse(usersClient.getUserWithId(5));
    }
}