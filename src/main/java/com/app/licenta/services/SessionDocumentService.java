package com.app.licenta.services;

import com.app.licenta.entities.Session;
import com.app.licenta.entities.SessionDocument;
import com.app.licenta.repositories.SessionDocumentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SessionDocumentService {

    @Autowired
    private SessionDocumentRepository sessionDocumentRepository;

    @Autowired
    private SessionService sessionService;

    public SessionDocument create(Integer sessionId, String title, MultipartFile file) throws IOException {
        SessionDocument document = new SessionDocument();
        Session session = sessionService.getById(sessionId);
        document.setSession(session);
        document.setTitle(title);
        document.setDocumentData(file.getBytes());
        session.getDocuments().add(document);
        return sessionDocumentRepository.save(document);
    }

    public SessionDocument getBySessionId(Integer sessionId) {
        return sessionDocumentRepository.findBySessionId(sessionId)
                .orElseThrow(() -> new EntityNotFoundException("Document not found"));
    }

    public void deleteById(Integer sessionId) {
        sessionDocumentRepository.deleteById(sessionId);
    }
}
