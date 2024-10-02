package curso.input;

import curso.modelo.Course;

import java.util.ArrayList;
import java.util.Optional;

public class Persistencia implements InterfacePersistence{

    private ArrayList<Course> cursos = new ArrayList<Course>();
    private Course course;

    public Persistencia(Course course) {
        this.course = course;
    }

    @Override
    public boolean existCourse() {
        return cursos.stream().anyMatch(curso -> curso.getNombre().equals(course.getNombre()));
    }

    @Override
    public void saveCourse(Course course) {
        cursos.add(course);
    }
}
