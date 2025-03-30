package com.app.licenta.controllers;

import com.app.licenta.entities.SessionDocument;
import com.app.licenta.services.SessionDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/session-documents")
public class SessionDocumentController {

    @Autowired
    private SessionDocumentService sessionDocumentService;

    @PostMapping("/create/{sessionId}")
    public ResponseEntity<String> create(@PathVariable Integer sessionId, @RequestPart("document") MultipartFile document) throws IOException {
        sessionDocumentService.create(sessionId, document);
        return ResponseEntity.status(HttpStatus.CREATED).body("Document uploaded successfully ");
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<byte[]> getDocumentBySessionId(@PathVariable Integer sessionId) {
        SessionDocument sessionDocument = sessionDocumentService.getBySessionId(sessionId);
        byte[] documentData = sessionDocument.getDocumentData();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(documentData, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        sessionDocumentService.deleteById(id);
    }
}
