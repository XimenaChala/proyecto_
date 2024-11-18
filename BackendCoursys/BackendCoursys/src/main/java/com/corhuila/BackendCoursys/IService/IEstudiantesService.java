package com.corhuila.BackendCoursys.IService;

import com.corhuila.BackendCoursys.Entity.Estudiantes;

import java.util.List;
import java.util.Optional;

public interface IEstudiantesService {

            Estudiantes save(Estudiantes estudiantes);
            void  update(Estudiantes estudiantes, Integer id);
            List<Estudiantes> all();
            Optional<Estudiantes> findById(Integer id);
            void delete(Integer id);
            Optional<Estudiantes> findByDocument(String cedula);
}
