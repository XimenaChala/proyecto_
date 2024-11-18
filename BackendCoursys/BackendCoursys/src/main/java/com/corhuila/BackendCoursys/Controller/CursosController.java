package com.corhuila.BackendCoursys.Controller;

import com.corhuila.BackendCoursys.Entity.Cursos;
import com.corhuila.BackendCoursys.IService.ICursosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/cursos")
public class CursosController {
    @Autowired
    private ICursosService service;

    @PostMapping("")
    public Cursos save(@RequestBody Cursos cursos) {
        return service.save(cursos);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Cursos cursos, @PathVariable Integer id) {
        service.update(cursos, id);
    }

    @GetMapping("")
    public List<Cursos> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<Cursos> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
