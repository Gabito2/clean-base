package curso.modelo;

import curso.exception.exceptionCursoIncompleto;
import java.time.LocalDate;
import java.util.UUID;

public class Course {
    private UUID id;
    private String name;
    private LocalDate fecha_cierre_inscripcion;
    private Level level;

    private Course(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level level) {
        this.id = id;
        this.name = name;
        this.fecha_cierre_inscripcion = fecha_cierre_inscripcion;
        this.level = level;
    }

    public static Course InstanciaCurso(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level level)
            throws exceptionCursoIncompleto {
        if (name == null || name.isEmpty())
            throw new exceptionCursoIncompleto("El nombre no puede ser nulo o estar vacio");
        if (id == null)
            throw new exceptionCursoIncompleto("El id no puede ser nulo");
        if (fecha_cierre_inscripcion == null || fecha_cierre_inscripcion.isBefore(LocalDate.now()))
            throw new exceptionCursoIncompleto("fecha_cierre_inscripcion no puede ser nulo o anterior a hoy");
        if (level == null)
            throw new exceptionCursoIncompleto("El nivel no puede ser nulo");

        return new Course(id, name, fecha_cierre_inscripcion, level);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFecha_cierre_inscripcion() {
        return fecha_cierre_inscripcion;
    }

    public Level getLevel() {
        return level;
    }


    //hacer el hashchode e equals sin el id por el test
}
