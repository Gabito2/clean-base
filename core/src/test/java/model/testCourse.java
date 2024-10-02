package model;

import curso.exception.exceptionCursoIncompleto;
import curso.modelo.Course;
import curso.modelo.level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class testCourse {

    @Test
    public void test() throws exceptionCursoIncompleto {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "Primero", LocalDate.of(2002, 11, 25), level.INICIAL);

        Assertions.assertNotNull(course);

        Assertions.assertEquals(course.getId(), course.getId());
    }

    @Test
    public void testNombreRepetido() throws exceptionCursoIncompleto {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "Primero", LocalDate.of(2002, 11, 25), level.INICIAL);
        Course course2 = Course.InstanciaCurso(UUID.randomUUID(), "Primero", LocalDate.of(2002, 11, 20), level.AVANZADO);

        Assertions.assertNotNull(course);

        Assertions.assertNotEquals(course.getNombre(), course2.getNombre());
    }

    @Test
    public void testLevel() throws exceptionCursoIncompleto {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "Primero", LocalDate.of(2002, 11, 25), null);

        Assertions.assertNotNull(course);

        Assertions.assertEquals(course.getNivel(), null);
    }


}
