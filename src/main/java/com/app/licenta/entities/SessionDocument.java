package com.app.licenta.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity(name = "session_document")
@Table(name = "session_document", schema = "public")
public class SessionDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "document_data", columnDefinition = "bytea")
    private byte[] documentData;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getDocumentData() {
        return documentData;
    }

    public void setDocumentData(byte[] documentData) {
        this.documentData = documentData;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
