package curso.usecase;

import curso.input.Persistencia;
import curso.modelo.Course;

public class CreateCourseUC implements InterfaceCreateCourseUC {
    private Persistencia persistencia;

    public CreateCourseUC(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    @Override
    public void createCourse(Course course) {
        persistencia.existCourse(course.getNombre());
        persistencia.saveCourse(course);
    }

}
