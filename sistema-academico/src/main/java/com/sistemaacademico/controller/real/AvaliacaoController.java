package com.sistemaacademico.controller.real;

import com.sistemaacademico.model.Avaliacao;
import com.sistemaacademico.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping
    public List<Avaliacao> listar() {
        return avaliacaoRepository.findAll();
    }

    @PostMapping
    public Avaliacao criar(@RequestBody Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        avaliacaoRepository.deleteById(id);
    }
}
