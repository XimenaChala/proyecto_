package com.corhuila.BackendCoursys.Service;

import com.corhuila.BackendCoursys.Entity.Cursos;
import com.corhuila.BackendCoursys.IRepository.ICursosRepository;
import com.corhuila.BackendCoursys.IService.ICursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosService implements ICursosService {
    @Autowired
    private ICursosRepository repository;

    @Override
    public Cursos save(Cursos cursos) {
        return repository.save(cursos);
    }

    @Override
    public void update(Cursos cursos, Integer id) {
        Optional <Cursos> up = repository.findById(id);

        if (up.isPresent()) {
            Cursos existingCursos = up.get();
            existingCursos.setNombre(cursos.getNombre());
            existingCursos.setEstudiantesId(cursos.getEstudiantesId());
            existingCursos.setProfesoresId(cursos.getProfesoresId());
            existingCursos.setHoras(cursos.getHoras());
            existingCursos.setFechaInicio(cursos.getFechaInicio());

            repository.save(existingCursos);
        }else {
            System.out.println("No existe registro con ID: " + id);
        }
    }

    @Override
    public List<Cursos> all() { return repository.findAll(); }

    @Override
    public Optional<Cursos> findById(Integer id) { return repository.findById(id); }

    @Override
    public void delete(Integer id) { repository.deleteById(id); }

}
