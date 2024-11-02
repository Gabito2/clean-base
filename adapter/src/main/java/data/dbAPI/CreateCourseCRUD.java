package data.dbAPI;

import data.model.CourseData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreateCourseCRUD extends CrudRepository<CourseData, UUID> {
    boolean existsByName(String name);
//    boolean save(CourseData courseData);
}
