package com.app.licenta.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/example")
public class RestController {

    @GetMapping("/hello")
    public ResponseEntity<String> getData() {
        return new ResponseEntity<>("Sunt serverul, domnule client. :)", HttpStatus.OK);
    }
}
