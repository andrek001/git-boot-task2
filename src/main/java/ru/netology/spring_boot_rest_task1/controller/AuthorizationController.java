package ru.netology.spring_boot_rest_task1.controller;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.spring_boot_rest_task1.model.Authorities;
import ru.netology.spring_boot_rest_task1.model.User;
import ru.netology.spring_boot_rest_task1.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/api")
    public class AuthorizationController {
        AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
        public List<Authorities> getAuthorities(@Valid User user) {
            return service.getAuthorities(user.getUser(), user.getPassword());
        }
    }
