package com.upao.tutoring_academic_support_api.controller;

import com.upao.tutoring_academic_support_api.domain.Report;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReportController {

    private List<Report> reportes = new ArrayList<>(); // Lista simulada

    @GetMapping
    public List<Report> getAllReportes() {
        return reportes;
    }

    @GetMapping("/{id}")
    public Report getReporteById(@PathVariable Long id) {
        return reportes.stream()
                .filter(reporte -> reporte.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Report createReporte(@RequestBody Report reporte) {
        reportes.add(reporte);
        return reporte;
    }

    @PutMapping("/{id}")
    public Report updateReporte(@PathVariable Long id, @RequestBody Report reporteDetalles) {
        Report reporte = getReporteById(id);
        if (reporte != null) {
            reporte.setDescripcion(reporteDetalles.getDescripcion());
            reporte.setFecha(reporteDetalles.getFecha());
        }
        return reporte;
    }

    @DeleteMapping("/{id}")
    public String deleteReporte(@PathVariable Long id) {
        Report reporte = getReporteById(id);
        if (reporte != null) {
            reportes.remove(reporte);
            return "Reporte eliminado";
        }
        return "Reporte no encontrado";
    }
}
