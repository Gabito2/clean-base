package curso.usecase;

import curso.exception.exceptionCursoIncompleto;
import curso.input.RegistrarCourseInput;
import curso.modelo.Course;
import curso.output.RegistrarCourseOutPut;

import java.util.ArrayList;

public class RegistrarCourseUC implements RegistrarCourseInput {
    private SearchCourseUC search;
    private RegistrarCourseOutPut registrarCourseOutPut;

    public RegistrarCourseUC(RegistrarCourseOutPut registrarCourseOutPut, SearchCourseUC search) {
        this.registrarCourseOutPut = registrarCourseOutPut;
        this.search = search;
    }

    @Override
    public boolean existCourse(String nombre) {
        return search.searchCourse().stream().anyMatch(course -> course.getNombre().equals(nombre));
    }

    @Override
    public boolean createCourse(Course course) {
        if (existCourse(course.getNombre())) {
            throw new RuntimeException("El curso ya existe");
        }
        return registrarCourseOutPut.saveCourse(course);
    }

    //Falta el CU de modificar, eliminar, listar por algun atributo para practicar para el parcial
}

