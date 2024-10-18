package curso.output;

import curso.modelo.Course;

public interface RegistrarCourseOutPut {
    boolean existsByName(String nombre);
    boolean saveCourse(Course course);
}
