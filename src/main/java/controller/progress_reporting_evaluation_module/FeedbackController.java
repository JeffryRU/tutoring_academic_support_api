package controller.progress_reporting_evaluation_module;

import domain.progress_reporting_evaluation_module.Feedback;
import service.user_management_module.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService; // Asume que tienes un servicio de feedback

    @PostMapping("/create")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = feedbackService.createFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedback); // Retorna 201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id)
                .map(ResponseEntity::ok) // Retorna 200 OK si el feedback está presente
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 Not Found si no está presente
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> feedbackList = feedbackService.getAllFeedback();
        return ResponseEntity.ok(feedbackList); // Retorna 200 OK con la lista de feedbacks
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback updatedFeedback) {
        return feedbackService.updateFeedback(id, updatedFeedback)
                .map(ResponseEntity::ok) // Retorna 200 OK con el feedback actualizado
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 Not Found si el feedback no existe
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        return feedbackService.deleteFeedback(id)
                ? ResponseEntity.ok("Feedback deleted successfully") // Retorna 200 OK con mensaje
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feedback not found"); // Retorna 404 Not Found con mensaje
    }
}
