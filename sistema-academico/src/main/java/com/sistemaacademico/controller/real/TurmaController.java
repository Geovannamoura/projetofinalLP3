package com.sistemaacademico.controller.real;

import com.sistemaacademico.model.Turma;
import com.sistemaacademico.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public List<Turma> listar() {
        return turmaRepository.findAll();
    }

    @PostMapping
    public Turma criar(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        turmaRepository.deleteById(id);
    }
}
