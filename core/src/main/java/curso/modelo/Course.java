package curso.modelo;

import curso.exception.exceptionCursoIncompleto;

import java.time.LocalDate;
import java.util.UUID;

public class Course {
    private UUID id;
    private String nombre;
    private LocalDate fecha_cierre_inscripcion;
    private level level;

    public Course(UUID id,
                  String nombre,
                  LocalDate fecha_cierre_inscripcion,
                  level level){
        this.id = id;
        this.nombre = nombre;
        this.fecha_cierre_inscripcion = fecha_cierre_inscripcion;
        this.level = level;
    }

    public static Course InstanciaCurso(UUID id,
                                        String nombre,
                                        LocalDate fecha_cierre_inscripcion,
                                        level level) throws exceptionCursoIncompleto {

        if (nombre == null || nombre.isEmpty())
            throw new exceptionCursoIncompleto("Faltan Datos");

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

    public level getNivel() {
        return level;
    }

}
