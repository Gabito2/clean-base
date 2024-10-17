package model;

import curso.input.RegistrarCourseInput;
import curso.modelo.Course;
import curso.modelo.Level;
import curso.output.RegistrarCourseOutPut;
import curso.usecase.RegistrarCourseUC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class testCourse {

    @Mock
    private RegistrarCourseOutPut registrarCourseOutPut;

    @InjectMocks
    private RegistrarCourseUC registrarCourseUC;

    @Test
    public void testRegistrarCourse() {
        Course course1 = Course.InstanciaCurso(UUID.randomUUID(), "Programacion", LocalDate.MAX, Level.AVANZADO);
        when(registrarCourseOutPut.existsByName("Programacion")).thenReturn(false);
        when(registrarCourseOutPut.saveCourse(course1)).thenReturn(true);

        boolean savecourse = registrarCourseUC.createCourse(course1);

        Assertions.assertTrue(savecourse);
        verify(registrarCourseOutPut, times(1)).saveCourse(course1);
    }

    @Test
    public void testRegistrarCurso_ExisteCurso() {
        Course curso = Course.InstanciaCurso(UUID.randomUUID(), "Programacion", LocalDate.now().plusDays(10), Level.MEDIO);

        when(registrarCourseOutPut.existsByName("Programacion")).thenReturn(true);

        Assertions.assertThrows(RuntimeException.class, () -> registrarCourseUC.createCourse(curso));
    }

    @Test
    public void testRegistrarCurso_NoSePudoGuardarCurso() {
        Course curso = Course.InstanciaCurso(UUID.randomUUID(), "fisica", LocalDate.now().plusDays(10), Level.MEDIO);

        when(registrarCourseOutPut.existsByName("fisica")).thenReturn(false);
        when(registrarCourseOutPut.saveCourse(curso)).thenReturn(false);

        boolean result = registrarCourseUC.createCourse(curso);

        Assertions.assertFalse(result);
        verify(registrarCourseOutPut, times(1)).saveCourse(curso);
    }

}
