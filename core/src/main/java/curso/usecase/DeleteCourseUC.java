package curso.usecase;

import curso.input.DeleteCourseInput;
import curso.output.DeleteCourseOutPut;

public class DeleteCourseUC implements DeleteCourseInput {
    private RegistrarCourseUC registrarCourseUC;
    private DeleteCourseOutPut deleteCourseOutPut;

    public DeleteCourseUC(RegistrarCourseUC registrarCourseUC) {
        this.registrarCourseUC = registrarCourseUC;
    }

    public boolean deleteCourse(String nombre){
        if (!registrarCourseUC.existCourse(nombre)){
            throw new RuntimeException("El curso no existe");
        }
        return deleteCourseOutPut.deleteCourse(nombre);
    }

}
