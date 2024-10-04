package model;

import curso.exception.exceptionCursoIncompleto;
import curso.input.Persistencia;
import curso.modelo.Course;
import curso.modelo.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class testCourse {

    @Test
    public void test() throws exceptionCursoIncompleto {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "Programacion", LocalDate.of(2021, 11, 25), Level.INICIAL);

        Assertions.assertNotNull(course);

        Assertions.assertEquals(course.getId(), course.getId());
    }

    @Test
    public void testNombreRepetido() throws exceptionCursoIncompleto {
        Persistencia persistencia = new Persistencia();

        Course course = Course.InstanciaCurso(UUID.randomUUID(), "Programacion", LocalDate.of(2024, 11, 25), Level.INICIAL);
        persistencia.saveCourse(course);

        Course course2 = Course.InstanciaCurso(UUID.randomUUID(), "Programacion", LocalDate.of(2024, 11, 25), Level.INICIAL);
        persistencia.saveCourse(course2);

        Assertions.assertEquals(false, persistencia.existCourse("Programacion"));
    }



    @Test
    public void testLevelPermitido() throws exceptionCursoIncompleto {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "Programacion", LocalDate.of(2021, 11, 25), Level.INICIAL);
        Assertions.assertEquals(Level.INICIAL, course.getNivel());

        Course course2 = Course.InstanciaCurso(UUID.randomUUID(), "Matematicas", LocalDate.of(2021, 11, 25), Level.MEDIO);
        Assertions.assertEquals(Level.MEDIO, course2.getNivel());

    }

    @Test
    public void testLevelInexistente() throws exceptionCursoIncompleto {
        Course course3 = Course.InstanciaCurso(UUID.randomUUID(), "Ciencias", LocalDate.of(2021, 11, 25), null);
        Assertions.assertEquals(Level.AVANZADO, course3.getNivel());        
    }
}