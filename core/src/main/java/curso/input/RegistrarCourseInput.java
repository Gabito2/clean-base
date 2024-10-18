package curso.input;

import curso.modelo.Course;
import curso.usecase.RegistrarCourseUC;

public interface RegistrarCourseInput {
    boolean createCourse(Course course);
    boolean existCourse(String nombre);
}

