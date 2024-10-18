package curso.usecase;

import curso.input.FindByNameInput;
import curso.modelo.Course;
import curso.output.FindByNameOutPut;

import java.util.NoSuchElementException;

public class FindByNameUC implements FindByNameInput {
    private SearchCourseUC searchCourseUC;
    private RegistrarCourseUC registrarCourseUC;

    public FindByNameUC(SearchCourseUC searchCourseUC, RegistrarCourseUC registrarCourseUC) {
        this.searchCourseUC = searchCourseUC;
        this.registrarCourseUC = registrarCourseUC;
    }

    @Override
    public String FindByName(String nombre){
        if (!registrarCourseUC.existCourse(nombre)){
            throw new RuntimeException("El curso no existe");
        }
        return searchCourseUC.searchCourse().stream().filter(course -> course.getNombre().equals(nombre)).findFirst().get().getNombre();
    }
}
