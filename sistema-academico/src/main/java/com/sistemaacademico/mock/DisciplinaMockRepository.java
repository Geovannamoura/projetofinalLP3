package com.sistemaacademico.mock;

import com.sistemaacademico.model.Disciplina;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DisciplinaMockRepository {

    private final List<Disciplina> disciplinas = new ArrayList<>();
    private Long nextId = 1L;

    public List<Disciplina> findAll() {
        return disciplinas;
    }

    public Optional<Disciplina> findById(Long id) {
        return disciplinas.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();
    }

    public Disciplina save(Disciplina disciplina) {
        if (disciplina.getId() == null) {
            disciplina.setId(nextId++);
            disciplinas.add(disciplina);
        } else {
            disciplinas.removeIf(d -> d.getId().equals(disciplina.getId()));
            disciplinas.add(disciplina);
        }
        return disciplina;
    }

    public void deleteById(Long id) {
        disciplinas.removeIf(d -> d.getId().equals(id));
    }

    public void clear() {
        disciplinas.clear();
        nextId = 1L;
    }
}
