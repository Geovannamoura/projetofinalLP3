package com.sistemaacademico.mock;

import com.sistemaacademico.model.Matricula;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatriculaMockRepository {

    private final List<Matricula> matriculas = new ArrayList<>();
    private Long nextId = 1L;

    public List<Matricula> findAll() {
        return matriculas;
    }

    public Optional<Matricula> findById(Long id) {
        return matriculas.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    public Matricula save(Matricula matricula) {
        if (matricula.getId() == null) {
            matricula.setId(nextId++);
            matriculas.add(matricula);
        } else {
            matriculas.removeIf(m -> m.getId().equals(matricula.getId()));
            matriculas.add(matricula);
        }
        return matricula;
    }

    public void deleteById(Long id) {
        matriculas.removeIf(m -> m.getId().equals(id));
    }

    public void clear() {
        matriculas.clear();
        nextId = 1L;
    }
}
