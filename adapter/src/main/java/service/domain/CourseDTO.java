package service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import curso.modelo.Course;
import curso.modelo.Level;

import java.time.LocalDate;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDTO {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("inscription_deadline")
    private LocalDate fecha_cierre_inscripcion;

    @JsonProperty("level")
    private Level level;

    public CourseDTO() {}

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.fecha_cierre_inscripcion = course.getFecha_cierre_inscripcion();
        this.level = course.getLevel();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFecha_cierre_inscripcion() {
        return fecha_cierre_inscripcion;
    }

    public Level getLevel() {
        return level;
    }
}
