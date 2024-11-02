package ar.edu.undec.adapter.data.curso;

import curso.modelo.Course;
import curso.modelo.Level;
import data.dbAPI.CreateCourseCRUD;
import data.model.CourseData;
import data.repository.CreateCourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCourseDataTest {

    @Mock
    CreateCourseCRUD createCourseCRUD;

    @InjectMocks //mock de una abstraccion que recibe un bean
    CreateCourseRepository createCourseRepository;

    @Test
    public void saveCourse_Course_Succesfull() {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "name", LocalDate.MAX, Level.AVANZADO);
        when(createCourseCRUD.save(any(CourseData.class))).thenReturn(new CourseData());
        boolean result = createCourseRepository.saveCourse(theCourse);
        Assertions.assertTrue(result);
    }

    @Test
    public void saveCourse_Course_returnFalse() {
        Course course = Course.InstanciaCurso(UUID.randomUUID(), "name", LocalDate.MAX, Level.AVANZADO);
        when(createCourseCRUD.save(any(CourseData.class))).thenThrow(RuntimeException.class);
        boolean result = createCourseRepository.saveCourse(course);
        Assertions.assertFalse(result);
    }

}
