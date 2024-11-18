package com.corhuila.BackendCoursys.Controller;

import com.corhuila.BackendCoursys.Entity.Estudiantes;
import com.corhuila.BackendCoursys.IService.IEstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/estudiantes")
public class EstudiantesController {
    @Autowired
    private IEstudiantesService service;

    @PostMapping("")
    public Estudiantes save(@RequestBody Estudiantes estudiantes) {
        return service.save(estudiantes);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Estudiantes estudiantes, @PathVariable Integer id) {
        service.update(estudiantes, id);
    }

    @GetMapping("")
    public List<Estudiantes> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<Estudiantes> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/findByDocument/{cedula}")
    public Optional<Estudiantes> findByDocument(@PathVariable String cedula){
        return service.findByDocument(cedula);
    }
}
