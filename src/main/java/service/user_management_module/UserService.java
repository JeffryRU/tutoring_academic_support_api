package service.user_management_module;

import domain.user_management_module.Student;
import domain.user_management_module.Tutor;
import domain.user_management_module.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>(); // Simulación de base de datos en memoria

    public Student createStudent(Student student) {
        users.add(student);
        return student;
    }

    public Tutor createTutor(Tutor tutor) {
        users.add(tutor);
        return tutor;
    }

    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Student updateStudent(Long id, Student student) {
        Optional<User> existingUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        if (existingUser.isPresent()) {
            student.setId(id);
            users.remove(existingUser.get());
            users.add(student);
            return student;
        } else {
            return null;
        }
    }

    public Tutor updateTutor(Long id, Tutor tutor) {
        Optional<User> existingUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        if (existingUser.isPresent()) {
            tutor.setId(id);
            users.remove(existingUser.get());
            users.add(tutor);
            return tutor;
        } else {
            return null;
        }
    }

    public boolean deleteUser(Long id) {
        Optional<User> existingUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        if (existingUser.isPresent()) {
            users.remove(existingUser.get());
            return true;
        } else {
            return false;
        }
    }
}
