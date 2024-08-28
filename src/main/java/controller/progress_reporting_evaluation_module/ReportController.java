package controller.progress_reporting_evaluation_module;

import domain.progress_reporting_evaluation_module.PerformanceReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService; // Asume que tienes un servicio de reportes

    @GetMapping("/performance/{studentId}")
    public ResponseEntity<PerformanceReport> getPerformanceReport(@PathVariable Long studentId) {
        PerformanceReport report = reportService.getPerformanceReport(studentId);
        if (report != null) {
            return ResponseEntity.ok(report);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
