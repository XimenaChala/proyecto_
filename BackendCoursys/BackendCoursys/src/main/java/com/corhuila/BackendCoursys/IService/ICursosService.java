package com.corhuila.BackendCoursys.IService;

import com.corhuila.BackendCoursys.Entity.Cursos;

import java.util.List;
import java.util.Optional;

public interface ICursosService {

            Cursos save(Cursos cursos);
            void  update(Cursos cursos, Integer id);
            List<Cursos> all();
            Optional<Cursos> findById(Integer id);
            void delete(Integer id);
}
