package curso.usecase;

import curso.exception.exceptionCursoIncompleto;
import curso.input.RegistrarCourseInput;
import curso.modelo.Course;
import curso.modelo.Level;
import curso.output.RegistrarCourseOutPut;
import curso.output.SearchCourseOutPut;

import java.time.LocalDate;
import java.util.UUID;

public class RegistrarCourseUC implements RegistrarCourseInput {
    private SearchCourseOutPut searchCourseOutPut;
    private RegistrarCourseOutPut registrarCourseOutPut;

    public RegistrarCourseUC(RegistrarCourseOutPut registrarCourseOutPut, SearchCourseOutPut searchCourseOutPut) {
        this.registrarCourseOutPut = registrarCourseOutPut;
        this.searchCourseOutPut = searchCourseOutPut;
    }

    @Override
    public boolean existCourse(String name) {
        return searchCourseOutPut.searchCourse().stream().anyMatch(course -> course.getName().equals(name));
    }

    @Override
    public boolean createCourse(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level level) { //le pasamos los atributos nomas
        //creamos un nuevo curso aqui
        if (registrarCourseOutPut.existsByName(name)) {
            throw new exceptionCursoIncompleto("Error, el curso ya existe");
        }
        Course course = Course.InstanciaCurso(UUID.randomUUID(), name, fecha_cierre_inscripcion, level);
        return registrarCourseOutPut.createCourse(course);
    }
}

