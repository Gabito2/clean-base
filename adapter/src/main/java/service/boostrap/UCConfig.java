package service.boostrap;

import curso.input.RegistrarCourseInput;
import curso.input.SearchCourseInput;
import curso.output.RegistrarCourseOutPut;
import curso.output.SearchCourseOutPut;
import curso.usecase.RegistrarCourseUC;
import curso.usecase.SearchCourseUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UCConfig {

    @Bean
    public RegistrarCourseInput registrarCourseOutPut(RegistrarCourseOutPut registrarCourseRepo) {
        return new RegistrarCourseUC(registrarCourseRepo);
    }
}
