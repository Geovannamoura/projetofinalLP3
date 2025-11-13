package com.sistemaacademico.mock;

import com.sistemaacademico.model.Nota;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotaMockRepository {

    private final List<Nota> notas = new ArrayList<>();
    private Long nextId = 1L;

    public List<Nota> findAll() {
        return notas;
    }

    public Optional<Nota> findById(Long id) {
        return notas.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst();
    }

    public Nota save(Nota nota) {
        if (nota.getId() == null) {
            nota.setId(nextId++);
            notas.add(nota);
        } else {
            notas.removeIf(n -> n.getId().equals(nota.getId()));
            notas.add(nota);
        }
        return nota;
    }

    public void deleteById(Long id) {
        notas.removeIf(n -> n.getId().equals(id));
    }

    public void clear() {
        notas.clear();
        nextId = 1L;
    }
}
