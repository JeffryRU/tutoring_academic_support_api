package com.upao.tutoring_academic_support_api.controller;

import com.upao.tutoring_academic_support_api.domain.Session;
import com.upao.tutoring_academic_support_api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id) {
        Optional<Session> session = sessionService.getSessionById(id);
        return session.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Session createSession(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}

