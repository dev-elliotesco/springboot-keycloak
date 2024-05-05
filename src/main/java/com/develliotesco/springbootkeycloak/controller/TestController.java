package com.develliotesco.springbootkeycloak.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin_client_role')")
    public String admin() {
        return "Hello ADMIN";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('user_client_role') or hasRole('admin_client_role')")
    public String user() {
        return "Hello USER";
    }
}
