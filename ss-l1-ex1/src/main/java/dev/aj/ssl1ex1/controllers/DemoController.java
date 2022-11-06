package dev.aj.ssl1ex1.controllers;

import dev.aj.ssl1ex1.domain.model.User;
import dev.aj.ssl1ex1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("demo")
@RequiredArgsConstructor
public class DemoController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getDemoText() {

        ResponseEntity responseEntity = new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);

        return responseEntity;
    }


}
