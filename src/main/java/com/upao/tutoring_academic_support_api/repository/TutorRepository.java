package com.upao.tutoring_academic_support_api.repository;

import com.upao.tutoring_academic_support_api.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
