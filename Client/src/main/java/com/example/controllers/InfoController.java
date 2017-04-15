package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paulzhang on 7/04/2017.
 */
@RestController
public class InfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoController.class);

    @GetMapping("/string")
    public String getSecuredString() {
        return "Secured info";
    }

    @GetMapping("/")
    public String index() {
        return "Public info";
    }
}
