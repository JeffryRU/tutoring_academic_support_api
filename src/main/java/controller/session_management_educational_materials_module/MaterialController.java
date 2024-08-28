package controller.session_management_educational_materials_module;

import domain.session_management_educational_materials_module.EducationalMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService; // Asume que tienes un servicio de materiales

    @PostMapping("/upload")
    public ResponseEntity<EducationalMaterial> uploadMaterial(@RequestBody EducationalMaterial material) {
        EducationalMaterial uploadedMaterial = materialService.uploadMaterial(material);
        return ResponseEntity.ok(uploadedMaterial);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EducationalMaterial>> getAllMaterials() {
        List<EducationalMaterial> materials = materialService.getAllMaterials();
        return ResponseEntity.ok(materials);
    }
}
