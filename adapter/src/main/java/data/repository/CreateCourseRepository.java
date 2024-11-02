package data.repository;

import curso.modelo.Course;
import curso.output.RegistrarCourseOutPut;
import data.dbAPI.CreateCourseCRUD;
import data.model.CourseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreateCourseRepository implements RegistrarCourseOutPut {

    CreateCourseCRUD createCourseCRUD;

    @Autowired
    public CreateCourseRepository(CreateCourseCRUD createCourseCRUD) {
        this.createCourseCRUD = createCourseCRUD;
    }

    @Override
    public boolean createCourse(Course course) {
        try {
            return createCourseCRUD.save(CourseData.fromDomain(course));
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean existsByName(String name){
        return createCourseCRUD.existsByName(name);
    }
}