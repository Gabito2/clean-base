package curso.input;
import curso.exception.exceptionCursoIncompleto;
import curso.modelo.Course;
import java.util.ArrayList;

public class Persistencia implements InterfacePersistence{

    private ArrayList<Course> cursos = new ArrayList<Course>();

    @Override
    public boolean saveCourse(Course course) {
        if (existCourse(course.getNombre())) {
            throw new exceptionCursoIncompleto("Ya existe el curso");
        }
        cursos.add(course);
        return true;
    }

    @Override
    public boolean existCourse(String nombre) {
        return cursos.stream().anyMatch(curso -> curso.getNombre().equals(nombre));
    }
}
