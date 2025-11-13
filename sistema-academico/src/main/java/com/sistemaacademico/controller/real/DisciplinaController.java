package com.sistemaacademico.controller.real;

import com.sistemaacademico.model.Disciplina;
import com.sistemaacademico.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }

    @PostMapping
    public Disciplina criar(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        disciplinaRepository.deleteById(id);
    }
}
