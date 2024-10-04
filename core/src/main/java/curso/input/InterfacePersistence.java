package curso.input;

import curso.modelo.Course;

public interface InterfacePersistence {

    boolean existCourse(String nombre);

    void saveCourse(Course course);
}
