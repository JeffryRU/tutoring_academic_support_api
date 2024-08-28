package controller.user_management_module;

import domain.user_management_module.Student;
import domain.user_management_module.Tutor;
import domain.user_management_module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.user_management_module.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService; // Asume que tienes un servicio de usuario

    @PostMapping("/create/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = userService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @PostMapping("/create/tutor")
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        Tutor createdTutor = userService.createTutor(tutor);
        return ResponseEntity.ok(createdTutor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = userService.updateStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/tutor/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor tutor) {
        Tutor updatedTutor = userService.updateTutor(id, tutor);
        if (updatedTutor != null) {
            return ResponseEntity.ok(updatedTutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}