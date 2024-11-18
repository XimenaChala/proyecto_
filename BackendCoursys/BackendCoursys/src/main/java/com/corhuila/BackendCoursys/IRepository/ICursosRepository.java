package com.corhuila.BackendCoursys.IRepository;
import com.corhuila.BackendCoursys.Entity.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursosRepository extends JpaRepository<Cursos, Integer> {
}
