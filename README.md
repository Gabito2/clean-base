# Programación Avanzada I (Backend)
### Ing. y Lic. en Sistemas

### Objetivos
- Desarrollar endpoints que permitan el registro y consulta de la entidad Curso

### Evaluacion
- Fecha de Entrega: 02/11/2024
- El proyecto debe compilar sin errores en cualquier entorno de programación en el que se abra
- Todos los test unitarios deben pasar en verde
- Cada funcionalidad debe tener su branch específica, la cual partirá desde el branch develop
- Se evaluará cada funcionalidad a través de Pull Request (o Merge Request) del branch feature hacia develop

### Punto de partida
- Se proveerá el esquema base de un Backend, de manera que el alumno pueda construir los dos endpoints desde cero.

## Consigna
#### Módulo Cursos
_Se desea implementar un backend para un microservicio que permita registrar y consultar cursos._

#### Restricciones:
- No puede existir dos Cursos con el mismo nombre
- Todos los atributos de Curso son obligatorios
- La fecha de cierre de inscripcion del Curso no puede ser inferior a la actual
- El level puede tomar solo los valores [Inicial, Medio, Avanzado]

#### Funcionalidad
- Crear Curso
  - Endpoint: POST http://localhost:8080/cursos
  - RequestBody:
    ```json
    {
      "id": null,
      "nombre": "Clean Architecture",
      "fecha_cierre_inscripcion": "2023-03-01T10:00:00.000Z",
      "level": "Inicial"
    }
    ```

- Buscar Cursos
  - Endpoint: GET http://localhost:8080/cursos

## Etapas

### Etapa 1
Creación de casos de uso que cubran la funcionalidad, aplicando patrones y principios de diseño SOLID

**Deadline: 12/10/24**

### Etapa 2
Creación de infraestructura para persistir y endpoints para comunicarse con la aplicación

**Deadline: 02/11/24**

#### Buenas prácticas y conceptos a considerar
- La nomenclatura de paquetes será en minúsculas
- La nomenclatura de clases será en UpperCamelCase
- La nomenclatura de métodos será en lowerCamelCase
- La organización de paquetes será por modelo->aspecto, tanto a level src/main como a level src/test. Ejemplo:
  ```
  cursos
  └─ excepciones
  └─ modelo
  └─ repositorio
  └─ casodeuso
  ```
- Usar Excepciones personalizadas
- Se debe usar método factory/instancia para crear objetos
- Nomenclatura representativa de clases, métodos, etc.
