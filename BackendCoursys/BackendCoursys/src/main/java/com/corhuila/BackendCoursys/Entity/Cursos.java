package com.corhuila.BackendCoursys.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cursos")
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estudiantes_id")
    private Estudiantes estudiantesId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "profesores_id")
    private Profesores profesoresId;

    @Column(name = "horas", nullable = false)
    private Float horas;

    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estudiantes getEstudiantesId() {
        return estudiantesId;
    }

    public void setEstudiantesId(Estudiantes estudiantesId) {
        this.estudiantesId = estudiantesId;
    }

    public Profesores getProfesoresId() {
        return profesoresId;
    }

    public void setProfesoresId(Profesores profesoresId) {
        this.profesoresId = profesoresId;
    }

    public Float getHoras() {
        return horas;
    }

    public void setHoras(Float horas) {
        this.horas = horas;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
