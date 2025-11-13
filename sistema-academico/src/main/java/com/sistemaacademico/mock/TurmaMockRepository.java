package com.sistemaacademico.mock;

import com.sistemaacademico.model.Turma;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurmaMockRepository {

    private final List<Turma> turmas = new ArrayList<>();
    private Long nextId = 1L;

    public List<Turma> findAll() {
        return turmas;
    }

    public Optional<Turma> findById(Long id) {
        return turmas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public Turma save(Turma turma) {
        if (turma.getId() == null) {
            turma.setId(nextId++);
            turmas.add(turma);
        } else {
            turmas.removeIf(t -> t.getId().equals(turma.getId()));
            turmas.add(turma);
        }
        return turma;
    }

    public void deleteById(Long id) {
        turmas.removeIf(t -> t.getId().equals(id));
    }

    public void clear() {
        turmas.clear();
        nextId = 1L;
    }
}
