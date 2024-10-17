package curso.usecase;

import curso.input.SearchCourseInput;
import curso.modelo.Course;
import curso.output.SearchCourseOutPut;

import java.util.ArrayList;

public class SearchCourseUC implements SearchCourseInput {
    private SearchCourseOutPut searchCourseOutPut;

    public SearchCourseUC(SearchCourseOutPut searchCourseOutPut) {
        this.searchCourseOutPut = searchCourseOutPut;
    }

    @Override
    public ArrayList<Course> searchCourse() {
        return searchCourseOutPut.searchCourse();
    }
}
