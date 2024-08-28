package service.tutor_search_selection_module;

import domain.tutor_search_selection_module.TutorProfile;
import domain.tutor_search_selection_module.TutorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorProfileService {

    @Autowired
    private TutorProfileRepository tutorProfileRepository;

    public TutorProfile createTutorProfile(TutorProfile tutorProfile) {
        return tutorProfileRepository.save(tutorProfile);
    }

    public Optional<TutorProfile> getTutorProfileById(Long id) {
        return tutorProfileRepository.findById(id);
    }

    public List<TutorProfile> getAllTutorProfiles() {
        return tutorProfileRepository.findAll();
    }

    public Optional<TutorProfile> updateTutorProfile(Long id, TutorProfile updatedProfile) {
        if (tutorProfileRepository.existsById(id)) {
            updatedProfile.setId(id);
            return Optional.of(tutorProfileRepository.save(updatedProfile));
        }
        return Optional.empty();
    }

    public boolean deleteTutorProfile(Long id) {
        if (tutorProfileRepository.existsById(id)) {
            tutorProfileRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
