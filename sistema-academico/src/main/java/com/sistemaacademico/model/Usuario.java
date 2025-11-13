package com.sistemaacademico.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senhaHash;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    private boolean ativo = true;

    public enum TipoUsuario {
        aluno, docente, admin
    }
}
