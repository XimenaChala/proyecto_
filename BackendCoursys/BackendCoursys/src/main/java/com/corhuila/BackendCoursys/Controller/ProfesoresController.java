package com.corhuila.BackendCoursys.Controller;

import com.corhuila.BackendCoursys.Entity.Profesores;
import com.corhuila.BackendCoursys.IService.IProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/profesores")
public class ProfesoresController {
    @Autowired
    private IProfesoresService service;

    @PostMapping("")
    public Profesores save(@RequestBody Profesores profesores) {
        return service.save(profesores);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Profesores profesores, @PathVariable Integer id) {
        service.update(profesores, id);
    }

    @GetMapping("")
    public List<Profesores> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<Profesores> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
