package com.corhuila.BackendCoursys.Service;

import com.corhuila.BackendCoursys.Entity.Estudiantes;
import com.corhuila.BackendCoursys.IRepository.IEstudiantesRepository;
import com.corhuila.BackendCoursys.IService.IEstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudiantesService implements IEstudiantesService {
    @Autowired
    private IEstudiantesRepository repository;

    @Override
    public Estudiantes save(Estudiantes estudiantes) {
        return repository.save(estudiantes);
    }

    @Override
    public void update(Estudiantes estudiantes, Integer id) {
        Optional <Estudiantes> up = repository.findById(id);

        if (up.isPresent()) {
            Estudiantes existingEstudiantes = up.get();
            existingEstudiantes.setNombre(estudiantes.getNombre());
            existingEstudiantes.setCedula(estudiantes.getCedula());
            existingEstudiantes.setTelefono(estudiantes.getTelefono());
            existingEstudiantes.setEmail(estudiantes.getEmail());

            repository.save(existingEstudiantes);
        }else {
            System.out.println("No existe registro con ID: " + id);
        }
    }

    @Override
    public List<Estudiantes> all() { return repository.findAll(); }

    @Override
    public Optional<Estudiantes> findById(Integer id) { return repository.findById(id); }

    @Override
    public void delete(Integer id) { repository.deleteById(id); }

    @Override
    public Optional<Estudiantes> findByDocument(String cedula) { return repository.findByDocument(cedula); }

}
