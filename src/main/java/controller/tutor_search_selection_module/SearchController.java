package controller.tutor_search_selection_module;

import domain.tutor_search_selection_module.TutorProfile;
import domain.tutor_search_selection_module.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService; // Asume que tienes un servicio de búsqueda

    @GetMapping("/tutors")
    public ResponseEntity<List<TutorProfile>> searchTutors(@RequestParam String criteria) {
        List<TutorProfile> profiles = searchService.searchTutors(criteria);
        return ResponseEntity.ok(profiles);
    }
}

