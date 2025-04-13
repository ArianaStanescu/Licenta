package com.app.licenta.controllers;

import com.app.licenta.dtos.SessionDocumentDto;
import com.app.licenta.entities.SessionDocument;
import com.app.licenta.services.SessionDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/session-documents")
public class SessionDocumentController {

    @Autowired
    private SessionDocumentService sessionDocumentService;

    @PostMapping("/create/{sessionId}")
    public ResponseEntity<String> create(@PathVariable Integer sessionId, @RequestPart("title") String title, @RequestPart("document") MultipartFile document) throws IOException {
        sessionDocumentService.create(sessionId, title, document);
        return ResponseEntity.status(HttpStatus.CREATED).body("Document uploaded successfully ");
    }

    @GetMapping("/title/{sessionId}")
    public ResponseEntity<SessionDocumentDto> getDocumentMeta(@PathVariable Integer sessionId) {
        SessionDocument sessionDocument = sessionDocumentService.getBySessionId(sessionId);

        SessionDocumentDto response = new SessionDocumentDto();
        response.setTitle(sessionDocument.getTitle());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/download/{sessionId}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Integer sessionId) {
        SessionDocument sessionDocument = sessionDocumentService.getBySessionId(sessionId);
        byte[] documentData = sessionDocument.getDocumentData();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        return new ResponseEntity<>(documentData, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteBySessionId(@PathVariable Integer id) {
        sessionDocumentService.deleteBySessionId(id);
    }
}
