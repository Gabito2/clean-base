package curso.usecase;

import curso.input.Persistencia;
import curso.modelo.Course;
import curso.modelo.level;

import java.time.LocalDate;
import java.util.UUID;

public class CreateCourseUS implements InterfaceCreateCourseUS {
    private Persistencia persistencia;
    private Course course;

    public CreateCourseUS(Persistencia persistencia, Course course) {
        this.persistencia = persistencia;
        this.course = course;
    }

    @Override
    public void createCourse(){
        Course.InstanciaCurso(course.getId(), course.getNombre(), course.getFecha_cierre_inscripcion(), course.getNivel());
        persistencia.existCourse();
        persistencia.saveCourse(course);
    }

}
