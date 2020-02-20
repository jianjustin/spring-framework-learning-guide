package org.janine.jian.controller;

import org.janine.jian.domain.User;
import org.janine.jian.security.JWTFilter;
import org.janine.jian.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import java.util.logging.Logger;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Api(tags = "auth")
public class AuthenticationController {
    @Autowired
    public TokenProvider tokenProvider;
    @Autowired
    public AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/auth/login")
    public ResponseEntity<String> authorize(@Valid @RequestBody User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.memberUserName, user.memberPassword);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        
        System.out.println("=========JWT Token Start==============");
        System.out.println(jwt);
        System.out.println("=========JWT Token End==============");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(jwt, httpHeaders, HttpStatus.OK);
    }

}
