package com.corhuila.BackendCoursys.IService;

import com.corhuila.BackendCoursys.Entity.Profesores;

import java.util.List;
import java.util.Optional;

public interface IProfesoresService {

            Profesores save(Profesores profesores);
            void  update(Profesores profesores, Integer id);
            List<Profesores> all();
            Optional<Profesores> findById(Integer id);
            void delete(Integer id);
}
