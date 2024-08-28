package controller.session_management_educational_materials_module;

import domain.session_management_educational_materials_module.AttendanceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService; // Asume que tienes un servicio de asistencia

    @PostMapping("/record")
    public ResponseEntity<AttendanceRecord> recordAttendance(@RequestBody AttendanceRecord record) {
        AttendanceRecord createdRecord = attendanceService.recordAttendance(record);
        return ResponseEntity.ok(createdRecord);
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<AttendanceRecord>> getAttendanceBySession(@PathVariable Long sessionId) {
        List<AttendanceRecord> records = attendanceService.getAttendanceBySession(sessionId);
        return ResponseEntity.ok(records);
    }
}
