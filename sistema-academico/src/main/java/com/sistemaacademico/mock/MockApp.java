package com.sistemaacademico.mock;
import com.sistemaacademico.mock.utl.ConsoleUtils;
import com.sistemaacademico.model.Usuario;
import com.sistemaacademico.model.Avaliacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Aplicação mockada executável via console.
 * Permite cadastrar usuários, login/logout e listar avaliações.
 * Tudo é feito em memória.
 */
public class MockApp {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<Avaliacao> avaliacoes = new ArrayList<>();
    private static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        System.out.println("===== SISTEMA ACADÊMICO MOCKADO =====");

        boolean rodando = true;
        while (rodando) {
            exibirMenuPrincipal();
            int opcao = ConsoleUtils.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> login();
                case 3 -> logout();
                case 4 -> listarUsuarios();
                case 5 -> menuAvaliacoes();
                case 0 -> {
                    System.out.println("Saindo do sistema... Até logo!");
                    rodando = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // =============================================================
    // ======================= MENU PRINCIPAL ======================
    // =============================================================

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Fazer Login");
        System.out.println("3. Fazer Logout");
        System.out.println("4. Listar Usuários");
        System.out.println("5. Gerenciar Avaliações");
        System.out.println("0. Sair");
    }

    // =============================================================
    // ======================= USUÁRIOS ============================
    // =============================================================

    private static void cadastrarUsuario() {
        System.out.println("\n--- CADASTRO DE USUÁRIO ---");
        String nome = ConsoleUtils.lerTexto("Nome: ");
        String email = ConsoleUtils.lerTexto("E-mail: ");
        String senha = ConsoleUtils.lerTexto("Senha: ");

        System.out.println("Tipos disponíveis: aluno | docente | admin");
        String tipoStr = ConsoleUtils.lerTexto("Tipo de usuário: ").toLowerCase();

        Usuario.TipoUsuario tipo;
        try {
            tipo = Usuario.TipoUsuario.valueOf(tipoStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo inválido. Usuário não cadastrado.");
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setId((long) (usuarios.size() + 1));
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenhaHash(senha); // sem criptografia por enquanto
        usuario.setTipo(tipo);
        usuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void login() {
        if (usuarioLogado != null) {
            System.out.println("Já existe um usuário logado: " + usuarioLogado.getNome());
            return;
        }

        System.out.println("\n--- LOGIN ---");
        String email = ConsoleUtils.lerTexto("E-mail: ");
        String senha = ConsoleUtils.lerTexto("Senha: ");

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenhaHash().equals(senha)) {
                usuarioLogado = u;
                System.out.println("Login realizado! Bem-vindo(a), " + u.getNome());
                return;
            }
        }
        System.out.println("Credenciais inválidas!");
    }

    private static void logout() {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário está logado.");
        } else {
            System.out.println("Logout realizado: " + usuarioLogado.getNome());
            usuarioLogado = null;
        }
    }

    private static void listarUsuarios() {
        System.out.println("\n--- LISTA DE USUÁRIOS ---");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() +
                        " | Tipo: " + u.getTipo() + " | Email: " + u.getEmail());
            }
        }
    }

    // =============================================================
    // ======================= AVALIAÇÕES ==========================
    // =============================================================

    private static void menuAvaliacoes() {
        if (usuarioLogado == null) {
            System.out.println("Faça login para acessar o menu de avaliações.");
            return;
        }

        boolean gerenciando = true;
        while (gerenciando) {
            System.out.println("\n--- MENU DE AVALIAÇÕES ---");
            System.out.println("1. Cadastrar Avaliação");
            System.out.println("2. Listar Avaliações");
            System.out.println("3. Excluir Avaliação");
            System.out.println("0. Voltar");

            int opcao = ConsoleUtils.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarAvaliacao();
                case 2 -> listarAvaliacoes();
                case 3 -> excluirAvaliacao();
                case 0 -> gerenciando = false;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarAvaliacao() {
        System.out.println("\n--- CADASTRO DE AVALIAÇÃO ---");
        String nome = ConsoleUtils.lerTexto("Nome da avaliação: ");
        int peso = ConsoleUtils.lerInt("Peso (0 a 10): ");

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId((long) (avaliacoes.size() + 1));
        avaliacao.setNome(nome);
        avaliacao.setPeso(peso);
        avaliacoes.add(avaliacao);

        System.out.println("Avaliação cadastrada com sucesso!");
    }

    private static void listarAvaliacoes() {
        System.out.println("\n--- LISTA DE AVALIAÇÕES ---");
        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação cadastrada.");
        } else {
            for (Avaliacao a : avaliacoes) {
                System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + " | Peso: " + a.getPeso());
            }
        }
    }

    private static void excluirAvaliacao() {
        long id = ConsoleUtils.lerLong("ID da avaliação a excluir: ");
        avaliacoes.removeIf(a -> a.getId() == id);
        System.out.println("Avaliação removida, se existia.");
    }
}
