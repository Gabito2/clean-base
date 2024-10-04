package curso.modelo;

import curso.exception.exceptionCursoIncompleto;

import java.time.LocalDate;
import java.util.UUID;

public class Course {
    private UUID id;
    private String nombre;
    private LocalDate fecha_cierre_inscripcion;
    private Level level;

    public Course(UUID id,
            String nombre,
            LocalDate fecha_cierre_inscripcion,
            Level level) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_cierre_inscripcion = fecha_cierre_inscripcion;
        this.level = level;
    }

    public static Course InstanciaCurso(UUID id,
            String nombre,
            LocalDate fecha_cierre_inscripcion,
            Level level) throws exceptionCursoIncompleto {

        if (nombre == null || nombre.isEmpty())
            throw new exceptionCursoIncompleto("El nombre no puede ser nulo o estar vacio");
        if (id == null)
            throw new exceptionCursoIncompleto("El id no puede ser nulo");
        if (fecha_cierre_inscripcion == null || fecha_cierre_inscripcion.isBefore(LocalDate.of(2010, 10, 25)))
            throw new exceptionCursoIncompleto("Fecha nula o anterior al 25/10/2010");
        if (level == null)
            throw new exceptionCursoIncompleto("El nivel no puede ser nulo");

        return new Course(id, nombre, fecha_cierre_inscripcion, level);
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha_cierre_inscripcion() {
        return fecha_cierre_inscripcion;
    }

    public Level getNivel() {
        return level;
    }

}
