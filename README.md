# COURSYS

### Objetivo del Proyecto
El objetivo principal del proyecto `Coursys` es desarrollar un sistema de gestión de cursos que facilite la administración y el seguimiento de estudiantes, profesores y cursos ofrecidos en una institución educativa. Este sistema busca automatizar procesos como la asignación de profesores a cursos, la inscripción de estudiantes, la gestión de horarios y el monitoreo de pagos, brindando una solución integral, eficiente y escalable.

### Contexto
Coursys surge como una herramienta para digitalizar y centralizar la gestión académica, permitiendo:

- Registrar estudiantes y profesores con sus datos clave.
- Gestionar cursos, incluyendo información sobre horarios, costos y asignaciones.
- Proveer un entorno seguro para la administración y consulta de información.

### Alcance
- Integración de estudiantes y profesores en una base de datos central.
- Relación entre cursos y participantes (estudiantes/profesores).
- Gestión eficiente de horarios, costos y fechas.


## Análisis: Definición de requerimientos. 

### Requisitos Funcionales

### RF1: Gestión de Estudiantes
- **Descripción:** El sistema permitirá a los administradores registrar, actualizar, eliminar y consultar información de estudiantes inscritos en los cursos.
- **Entrada:** Datos del estudiante (Nombre, cédula, teléfono, correo electrónico).
- **Procesamiento:** Validar unicidad de la cédula y almacenar los datos en la tabla `estudiantes`.
- **Salida:** Confirmación de registro o actualización del estudiante.

### RF2: Gestión de Profesores
- **Descripción:** El sistema permitirá registrar, actualizar, eliminar y consultar los datos de los profesores.
- **Entrada:** Datos del profesor (Nombre, especialidad, correo electrónico).
- **Procesamiento:** Validar los datos y relacionarlos con los cursos correspondientes.
- **Salida:** Confirmación del registro, actualización o eliminación del profesor.

### RF3: Creación de Cursos
- **Descripción:** El sistema permitirá registrar nuevos cursos con asignación de profesores y estudiantes.
- **Entrada:** Datos del curso (Nombre, horas, precio, fecha de inicio, profesor asignado, estudiantes inscritos).
- **Procesamiento:** Validar la existencia de profesores y estudiantes relacionados, y guardar el curso en la tabla `cursos`.
- **Salida:** Confirmación de la creación del curso.

### RF4: Inscripción de Estudiantes en Cursos
- **Descripción:** El sistema permitirá asignar estudiantes a cursos existentes.
- **Entrada:** Datos de inscripción (ID del estudiante, ID del curso).
- **Procesamiento:** Validar la existencia del estudiante y el curso, y registrar la relación en el sistema.
- **Salida:** Confirmación de inscripción.

### RF5: Consultas de Cursos
- **Descripción:** El sistema permitirá listar los cursos disponibles y sus detalles, como estudiantes inscritos y profesor asignado.
- **Entrada:** Solicitud de consulta por curso o filtro por profesor o estudiante.
- **Procesamiento:** Consultar la base de datos para recuperar la información solicitada.
- **Salida:** Lista detallada de cursos con sus asignaciones.

---

### Requerimientos No Funcionales

### RNF1: Seguridad de Acceso
- **Descripción:** El sistema debe garantizar que solo usuarios autorizados puedan realizar cambios en los datos.
- **Entrada:** Credenciales del usuario (nombre de usuario y contraseña).
- **Procesamiento:** Validar las credenciales y otorgar acceso según el rol.
- **Salida:** Acceso permitido o denegado.

### RNF2: Rendimiento
- **Descripción:** El sistema debe procesar solicitudes en un tiempo promedio menor a 2 segundos.
- **Entrada:** Solicitud de consulta o registro.
- **Procesamiento:** Ejecución de operaciones en la base de datos y presentación de resultados.
- **Salida:** Respuesta rápida a las solicitudes del usuario.

### RNF3: Disponibilidad
- **Descripción:** El sistema debe estar disponible al menos el 99.9% del tiempo para garantizar operaciones continuas.
- **Entrada:** Uso de la aplicación por parte de los usuarios.
- **Procesamiento:** Monitoreo y mantenimiento de los servicios.
- **Salida:** Operación continua sin interrupciones significativas.

### RNF4: Escalabilidad
- **Descripción:** El sistema debe ser capaz de manejar un aumento en la cantidad de usuarios y cursos sin pérdida de rendimiento.
- **Entrada:** Aumento en los datos y usuarios concurrentes.
- **Procesamiento:** Ajuste dinámico de los recursos del servidor.
- **Salida:** Respuesta eficiente y escalable.

### RNF5: Compatibilidad
- **Descripción:** El sistema debe ser accesible desde navegadores web modernos y dispositivos móviles.
- **Entrada:** Acceso desde diversos dispositivos.
- **Procesamiento:** Adaptación de la interfaz al entorno del usuario.
- **Salida:** Interfaz funcional y adaptada.



## Diseño Base de Datos
> Script de la Base de Datos

```sql
DROP DATABASE IF EXISTS Coursys;

    CREATE DATABASE Coursys;

    USE Coursys;

-- Tabla Estudiantes
CREATE TABLE estudiantes (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    cedula VARCHAR(100) NOT NULL,
    telefono FLOAT NOT NULL,
    email VARCHAR(200) NOT NULL
);

-- Tabla Profesores
CREATE TABLE profesores (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    especialidad VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL
);

-- Tabla Cursos
CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    estudiantes_id INT NOT NULL,
    profesores_id INT NOT NULL,
    horas FLOAT NOT NULL,
    precio FLOAT NOT NULL,
    fecha_inicio TIMESTAMP NOT NULL,
    CONSTRAINT fk_estudiantes FOREIGN KEY (estudiantes_id) REFERENCES estudiantes (id),
    CONSTRAINT fk_profesores FOREIGN KEY (profesores_id) REFERENCES profesores (id)
);

```

## Mockup
El diseño del modelado se enfoca en una interfaz gráfica e interactiva para gestionar estudiantes, profesores y cursos. Este diseño está orientado a facilitar la gestión académica sin necesidad de roles o inicios de sesión.

![Home](Imagenes%20Layout/HomePage.png)