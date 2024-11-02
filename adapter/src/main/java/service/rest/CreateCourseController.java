package service.rest;

import curso.input.RegistrarCourseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.domain.CourseDTO;

@RestController
@RequestMapping("/course")
public class CreateCourseController {

    private final RegistrarCourseInput registrarCourseInput;

    @Autowired
    public CreateCourseController(RegistrarCourseInput registrarCourseInput) {
        this.registrarCourseInput = registrarCourseInput;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDTO) {
        try {
            return ResponseEntity.ok().body(
                    registrarCourseInput.createCourse(
                            courseDTO.getId(), courseDTO.getName(), courseDTO.getFecha_cierre_inscripcion(), courseDTO.getLevel()
                    ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

//existByName(name and Not id)