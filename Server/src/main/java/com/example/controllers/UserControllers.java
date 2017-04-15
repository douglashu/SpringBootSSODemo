package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by paulzhang on 7/04/2017.
 */
@RestController
public class UserControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllers.class);

    @RequestMapping(value = "/user")
    public Principal getUser(Principal principal) {
        LOGGER.info("GET USER RESOURCE");
        LOGGER.info(principal.toString());
//        Map<String, String> userMap = new HashMap<>();
//        userMap.put("name", principal.getName());
//        return userMap;
        return principal;
    }
}
