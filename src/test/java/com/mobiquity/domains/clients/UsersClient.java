package com.mobiquity.domains.clients;

import com.mobiquity.domains.builders.UserBuilder;
import com.mobiquity.domains.entity.User;
import com.mobiquity.domains.response.UsersResponse;
import com.mobiquity.domains.services.UsersServices;

public class UsersClient {

    private final UsersServices usersServices;

    public UsersClient() {
        usersServices = new UsersServices();
    }

    public UsersResponse getUserWithUsername(String username) {
        return usersServices.getUserWithUsername(username)[0];
    }

    public int getLatestUserId() {
        int length = usersServices.getAllUsers().length;
        return usersServices.getAllUsers()[length - 1].id;
    }

    public boolean getUserWithId(int userId) {
        return usersServices.getUserWithID(userId);
    }

    public int postUser() {
        User user = new UserBuilder().build();
        return usersServices.postUser(user);
    }

    public boolean deleteUser(int userId) {
        return usersServices.deleteUser(userId);
    }
}
