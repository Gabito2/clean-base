package curso.input;

import curso.modelo.Course;
import curso.modelo.Level;
import curso.usecase.RegistrarCourseUC;

import java.time.LocalDate;
import java.util.UUID;

public interface RegistrarCourseInput {
    //boolean createCourse(Course course);
    boolean existCourse(String name);

//    Object createCourse(UUID id, String name, LocalDate fechaCierreInscripcion, Level level);
    boolean createCourse(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level level);
}

