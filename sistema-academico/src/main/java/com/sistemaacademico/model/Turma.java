package com.sistemaacademico.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "turmas")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Usuario docente;
}
