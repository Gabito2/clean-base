package curso.input;

import curso.modelo.Course;

public interface InterfacePersistence {

    boolean saveCourse(Course course);

    boolean existCourse(String nombre);
}
