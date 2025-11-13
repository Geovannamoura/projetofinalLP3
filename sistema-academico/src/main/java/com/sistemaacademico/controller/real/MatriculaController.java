package com.sistemaacademico.controller.real;

import com.sistemaacademico.model.Matricula;
import com.sistemaacademico.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping
    public List<Matricula> listar() {
        return matriculaRepository.findAll();
    }

    @PostMapping
    public Matricula criar(@RequestBody Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        matriculaRepository.deleteById(id);
    }
}
