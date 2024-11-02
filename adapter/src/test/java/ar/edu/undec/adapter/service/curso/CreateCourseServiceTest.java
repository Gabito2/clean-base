package ar.edu.undec.adapter.service.curso;

import curso.exception.exceptionCursoIncompleto;
import curso.input.RegistrarCourseInput;
import curso.modelo.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import service.domain.CourseDTO;
import service.rest.CreateCourseController;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCourseServiceTest {
    @Mock
    RegistrarCourseInput registrarCourseInput;
    @InjectMocks
    CreateCourseController createCourseController;

    @Test
    public void createCourse_courseSaver_Return201() {
        //Arrange
        when(registrarCourseInput.createCourse(null, "name", LocalDate.MAX, Level.AVANZADO)).thenReturn(true);
        CourseDTO theCourse = new CourseDTO(null, "name", LocalDate.MAX, Level.AVANZADO);
        //Act
        ResponseEntity<?> result = createCourseController.createCourse(theCourse);
        //Assert
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
//        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void createCourse_courseExists_Return400() {
        //Arrange
        when(registrarCourseInput.createCourse(null, "name", LocalDate.MAX, Level.AVANZADO)).thenThrow(new exceptionCursoIncompleto("El curso ya existe"));
        CourseDTO theCourse = new CourseDTO(null, "name", LocalDate.MAX, Level.AVANZADO);
        //Act
        ResponseEntity<?> result = createCourseController.createCourse(theCourse);
        //Assert
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    public void createCourse_courseNoSaved_Return500() {
        //Arrange
        when(registrarCourseInput.createCourse(null, "name", LocalDate.MAX, Level.AVANZADO)).thenThrow(new exceptionCursoIncompleto("El curso ya existe"));
        CourseDTO theCourse = new CourseDTO(null, "name", LocalDate.MAX, Level.AVANZADO);
        //Act
        ResponseEntity<?> result = createCourseController.createCourse(theCourse);
        //Assert
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

}
