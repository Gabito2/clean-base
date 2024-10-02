package curso.input;

import curso.modelo.Course;

public interface InterfacePersistence {
    boolean existCourse();
    void saveCourse(Course course);
}
