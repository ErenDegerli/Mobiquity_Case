package com.mobiquity.domains.clients;

import com.mobiquity.domains.services.PostServices;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class PostClient {

    private final PostServices postServices;
    private final Logger logger = Logger.getLogger(PostClient.class);

    public PostClient() {
        postServices = new PostServices();
    }

    public ArrayList<Integer> getPostIdsOfAUser(int userId) {
        logger.info("Getting of a user's all Posts whose ID is = " + userId);
        return postServices.getAllPostsIdsOfAUser(userId);
    }
}