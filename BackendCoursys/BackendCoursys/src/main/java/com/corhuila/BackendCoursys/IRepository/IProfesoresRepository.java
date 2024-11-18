package com.corhuila.BackendCoursys.IRepository;
import com.corhuila.BackendCoursys.Entity.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesoresRepository extends JpaRepository<Profesores, Integer> {
}
