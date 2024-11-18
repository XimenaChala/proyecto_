package com.corhuila.BackendCoursys.Service;

import com.corhuila.BackendCoursys.Entity.Profesores;
import com.corhuila.BackendCoursys.IRepository.IProfesoresRepository;
import com.corhuila.BackendCoursys.IService.IProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesoresService implements IProfesoresService {
    @Autowired
    private IProfesoresRepository repository;

    @Override
    public Profesores save(Profesores profesores) {
        return repository.save(profesores);
    }

    @Override
    public void update(Profesores profesores, Integer id) {
        Optional <Profesores> up = repository.findById(id);

        if (up.isPresent()) {
            Profesores existingProfesores = up.get();
            existingProfesores.setNombre(profesores.getNombre());
            existingProfesores.setEspecialidad(profesores.getEspecialidad());
            existingProfesores.setEmail(profesores.getEmail());

            repository.save(existingProfesores);
        }else {
            System.out.println("No existe registro con ID: " + id);
        }
    }

    @Override
    public List<Profesores> all() { return repository.findAll(); }

    @Override
    public Optional<Profesores> findById(Integer id) { return repository.findById(id); }

    @Override
    public void delete(Integer id) { repository.deleteById(id); }

}
