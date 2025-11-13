package com.sistemaacademico.controller.real;

import com.sistemaacademico.model.Nota;
import com.sistemaacademico.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @GetMapping
    public List<Nota> listar() {
        return notaRepository.findAll();
    }

    @PostMapping
    public Nota criar(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        notaRepository.deleteById(id);
    }
}
