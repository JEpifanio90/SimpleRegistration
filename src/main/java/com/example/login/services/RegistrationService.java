package com.example.login.services;

import com.example.login.enums.UserRole;
import com.example.login.models.RegistrationRequest;
import com.example.login.models.AppUser;
import com.example.login.validators.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isEmailValid = emailValidator.test(request.getEmail());

        if (!isEmailValid) {
            throw new IllegalStateException("Email is not valid");
        }


        return userService.singUpUser(new AppUser(
                String.format("%s %s", request.getFirstName(), request.getLastName()),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER,
                false,
                true
        ));
    }
}
