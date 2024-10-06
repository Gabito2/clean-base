package model;

import curso.exception.exceptionCursoIncompleto;
import curso.input.InterfacePersistence;
import curso.modelo.Course;
import curso.modelo.Level;
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
    private InterfacePersistence persistence;

    @InjectMocks
    private Course course;

    @Test
    public void createCourse() throws exceptionCursoIncompleto {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "Programacion", LocalDate.of(2014, 10, 10), Level.AVANZADO);

        when(persistence.existCourse(course.getNombre())).thenReturn(false);
        Assertions.assertFalse(persistence.existCourse(course.getNombre()));
        persistence.saveCourse(course);
        
        verify(persistence, times(1)).saveCourse(course);
        when(persistence.existCourse(course.getNombre())).thenReturn(true);
        Assertions.assertTrue(persistence.existCourse(course.getNombre()));
    }

    @Test
    public void createCourseExists() throws exceptionCursoIncompleto {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "Programacion", LocalDate.of(2014, 10, 10), Level.AVANZADO);
        when(persistence.existCourse(course.getNombre())).thenReturn(true);

        Assertions.assertThrows(exceptionCursoIncompleto.class, () -> {
            persistence.saveCourse(course);
        });

        verify(persistence, never()).saveCourse(course);
    }

    @Test
    public void createCourseFail() throws exceptionCursoIncompleto {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "Programacion", LocalDate.of(2014, 10, 10), Level.AVANZADO);

        doThrow(new RuntimeException("Failed to save course")).when(persistence).saveCourse(course);

        Assertions.assertThrows(RuntimeException.class, () -> {
            persistence.saveCourse(course);
        });

        verify(persistence, times(1)).saveCourse(course);
    }
}
