package com.sistemaacademico.mock;

import com.sistemaacademico.model.Usuario;

import java.util.*;

public class UsuarioMockRepository {
    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private long nextId = 1;

    public Usuario save(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(nextId++);
        }
        usuarios.put(usuario.getId(), usuario);
        System.out.println("[MOCK] Usuário salvo: " + usuario);
        return usuario;
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarios.values().stream()
                .filter(u -> u.getEmail() != null && u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public void deleteById(Long id) {
        usuarios.remove(id);
    }

    public void clear() {
        usuarios.clear();
        nextId = 1;
    }
}
