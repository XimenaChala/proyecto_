package com.corhuila.BackendCoursys.IRepository;
import com.corhuila.BackendCoursys.Entity.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IEstudiantesRepository extends JpaRepository<Estudiantes, Integer> {

    @Query(value = "SELECT * FROM estudientes WHERE cedula = :cedula ",nativeQuery = true)
    Optional<Estudiantes> findByDocument(String cedula);
}
