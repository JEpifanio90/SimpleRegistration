package com.example.login.controllers;

import com.example.login.models.RegistrationRequest;
import com.example.login.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping("confirmation")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
