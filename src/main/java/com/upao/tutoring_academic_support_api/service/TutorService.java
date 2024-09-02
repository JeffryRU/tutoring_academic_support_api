package com.upao.tutoring_academic_support_api.service;

import com.upao.tutoring_academic_support_api.domain.Tutor;
import com.upao.tutoring_academic_support_api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> getTutorById(Long id) {
        return tutorRepository.findById(id);
    }

    public Tutor createTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }
}

