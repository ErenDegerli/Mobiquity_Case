package com.mobiquity.domains.clients;

import com.mobiquity.domains.services.PostServices;
import java.util.ArrayList;

public class PostClient {

    private final PostServices postServices;

    public PostClient() {
        postServices = new PostServices();
    }

    public ArrayList<Integer> getPostIdsOfAUser(int userId) {
        return postServices.getAllPostsIdsOfAUser(userId);
    }
}