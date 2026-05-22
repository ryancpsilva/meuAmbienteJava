package ex03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(4, 4);

        String[] simbolos = {"A", "B", "C", "D", "E", "F", "G", "H"};
        tabuleiro.inicializar(simbolos);
        tabuleiro.exibir();

        try (Scanner scanner = new Scanner(System.in)) {
            while (!tabuleiro.isVitoria()) {
                System.out.println("Escolha a primeira carta (linha): ");   
                int linha1 = scanner.nextInt() - 1; // Ajusta para índice
                System.out.println("Escolha a primeira carta (coluna): ");
                int coluna1 = scanner.nextInt() - 1; // Ajusta para índice
                if (!tabuleiro.revelarCarta(linha1, coluna1)) {
                    continue;
                }
                tabuleiro.exibir();
                System.out.println("Escolha a segunda carta (linha): ");
                int linha2 = scanner.nextInt() - 1; // Ajusta para índice
                System.out.println("Escolha a segunda carta (coluna): ");
                int coluna2 = scanner.nextInt() - 1; // Ajusta para índice
                if (!tabuleiro.revelarCarta(linha2, coluna2)) {
                    continue;
                }
            
                if (tabuleiro.verificarPar(linha1, coluna1, linha2, coluna2)) {
                    System.out.println("Par encontrado!");
                } else {
                
                    System.out.println("Não é um par. As cartas serão viradas novamente.");
                    tabuleiro.exibir();
                }
            }
            System.out.println("Parabéns! Você encontrou todos os pares!");
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, insira números válidos.");
        }
    }
}
