package com.sistemaacademico.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "matriculas")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Usuario aluno;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    private Double notaFinal;
}
