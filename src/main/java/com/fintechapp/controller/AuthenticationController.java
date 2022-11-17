package com.fintechapp.controller;

import com.fintechapp.helper.AppConstantApi;
import com.fintechapp.helper.BaseResponse;
import com.fintechapp.model.ClientDetails;
import com.fintechapp.model.dto.authentication.AuthenticationRequestDto;
import com.fintechapp.model.dto.public_token.SignUpDetailsDto;
import com.fintechapp.service.AccountService;
import com.fintechapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {


    @Autowired
    AuthenticationService userAuthenticationService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountService accountService;



    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDetailsDto signUpDetailsDto){

        SignUpDetailsDto  userDetails= new SignUpDetailsDto(signUpDetailsDto.getUserName(),signUpDetailsDto.getUserEmail(),passwordEncoder.encode(signUpDetailsDto.getUserPassword()));

        return  userAuthenticationService.saveUserDetails(userDetails);
    }


    @PostMapping("/login")
    public ResponseEntity<?> signInUser(@RequestBody AuthenticationRequestDto authenticationRequestDto) throws Exception {

        return  userAuthenticationService.checkAuthentication(authenticationRequestDto);
    }


}
