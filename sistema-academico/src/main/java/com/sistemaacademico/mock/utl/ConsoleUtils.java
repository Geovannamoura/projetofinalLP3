package com.sistemaacademico.mock.utl;

import java.util.Scanner;

/**
 * Classe utilitária simples para leitura de dados no console.
 * Facilita a entrada de texto e números pelo usuário.
 */
public class ConsoleUtils {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Lê uma linha de texto (String).
     */
    public static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    /**
     * Lê um número inteiro.
     */
    public static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
            }
        }
    }

    /**
     * Lê um número long.
     */
    public static long lerLong(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                String input = scanner.nextLine();
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número válido.");
            }
        }
    }

    /**
     * Pergunta se o usuário deseja continuar (S/N).
     */
    public static boolean confirmar(String mensagem) {
        System.out.print(mensagem + " (S/N): ");
        String resposta = scanner.nextLine().trim().toLowerCase();
        return resposta.startsWith("s");
    }
}
