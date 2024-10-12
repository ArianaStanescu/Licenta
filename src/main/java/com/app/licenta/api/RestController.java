package com.app.licenta.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/api/hello")
    public ResponseEntity<String> getData() {
        return new ResponseEntity<>("Sunt serverul, domnule client. :)", HttpStatus.OK);
    }
}
