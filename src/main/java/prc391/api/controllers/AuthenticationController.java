package prc391.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prc391.api.services.AuthenticationService;
import prc391.lib.models.common.BaseResponseModel;

import java.io.IOException;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public BaseResponseModel login(@RequestParam("tokenId") String tokenId) {
        try {
            return this.authenticationService.login(tokenId);
        } catch (IOException ex) {
            return new BaseResponseModel("Invalid user!");
        }
    }

    @GetMapping("/authenUser")
    public BaseResponseModel checkAuthenUser(@RequestParam("token") final String token) {
        return this.authenticationService.checkAuthenUser(token);
    }
}
