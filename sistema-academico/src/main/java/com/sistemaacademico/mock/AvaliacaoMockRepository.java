package com.sistemaacademico.mock;

import com.sistemaacademico.model.Avaliacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AvaliacaoMockRepository {

    private final List<Avaliacao> avaliacoes = new ArrayList<>();
    private Long nextId = 1L;

    public List<Avaliacao> findAll() {
        return avaliacoes;
    }

    public Optional<Avaliacao> findById(Long id) {
        return avaliacoes.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    public Avaliacao save(Avaliacao avaliacao) {
        if (avaliacao.getId() == null) {
            avaliacao.setId(nextId++);
            avaliacoes.add(avaliacao);
        } else {
            avaliacoes.removeIf(a -> a.getId().equals(avaliacao.getId()));
            avaliacoes.add(avaliacao);
        }
        return avaliacao;
    }

    public void deleteById(Long id) {
        avaliacoes.removeIf(a -> a.getId().equals(id));
    }

    public void clear() {
        avaliacoes.clear();
        nextId = 1L;
    }
}
