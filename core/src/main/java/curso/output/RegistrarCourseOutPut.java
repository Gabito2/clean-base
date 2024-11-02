package curso.output;

import curso.modelo.Course;

public interface RegistrarCourseOutPut {
    boolean existsByName(String name);
    boolean createCourse(Course course);
}
