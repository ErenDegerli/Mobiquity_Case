package com.mobiquity.domains.services;

import com.mobiquity.core.client.RestClient;
import com.mobiquity.domains.entity.User;
import com.mobiquity.domains.response.UsersResponse;
import org.apache.http.HttpStatus;

public class UsersServices extends RestClient {

    private final String endpoint;

    public UsersServices() {
        this.endpoint = "/users";
    }

    public UsersResponse[] getUserWithUsername(String username) {
        return getWithQueryParam(endpoint,"username",username).as(UsersResponse[].class);
    }

    public UsersResponse[] getAllUsers() {
        return get(endpoint).as(UsersResponse[].class);
    }

    public boolean getUserWithID(int userId) {
        return getWithQueryParam(endpoint, "id", userId).getStatusCode() == HttpStatus.SC_OK;
    }

    public int postUser(User user) {
        return post(endpoint,user).then().extract().path("id");
    }

    public boolean deleteUser(int userId) {
        return delete(endpoint + "/" + userId).getStatusCode() == HttpStatus.SC_OK;
    }
}