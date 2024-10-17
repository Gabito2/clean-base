package curso.usecase;

import curso.exception.exceptionCursoIncompleto;
import curso.input.RegistrarCourseInput;
import curso.modelo.Course;
import curso.output.RegistrarCourseOutPut;

import java.util.ArrayList;

public class RegistrarCourseUC implements RegistrarCourseInput {

    private RegistrarCourseOutPut registrarCourseOutPut;

    public RegistrarCourseUC(RegistrarCourseOutPut registrarCourseOutPut) {
        this.registrarCourseOutPut = registrarCourseOutPut;
    }

    @Override
    public boolean existCourse(String nombre) {
        return registrarCourseOutPut.existsByName(nombre);
    }

    @Override
    public boolean createCourse(Course course) {
        if (existCourse(course.getNombre())) {
            throw new RuntimeException("El curso ya existe");
        }
        return registrarCourseOutPut.saveCourse(course);
    }
}

