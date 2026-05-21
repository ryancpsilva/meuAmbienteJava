package ex04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(4, 4);
        EstadoJogo estadoJogo = new EstadoJogo();

        String[] simbolos = {"A", "B", "C", "D", "E", "F", "G", "H"};
        tabuleiro.inicializar(simbolos);
        tabuleiro.exibir();

        try (Scanner scanner = new Scanner(System.in)) {
            int tentativas = 0;
            while (!tabuleiro.isVitoria()) {
                System.out.println(">>Tentativas: " + tentativas);
                System.out.println("");
                System.out.println("Escolha a primeira carta (linha), '0' para salvar o jogo ou '-1' para carregar o jogo: ");   
                int linha1 = scanner.nextInt() - 1; // Ajusta para índice
                if (linha1 == -2) { // O jogador escolheu carregar o jogo
                    EstadoJogo estadoCarregado = estadoJogo.carregarJogo("estado_jogo.mem");
                    if (estadoCarregado != null) {
                        // Atualiza o tabuleiro e as tentativas com os valores carregados
                        tabuleiro = estadoCarregado.getTabuleiro();
                        tentativas = estadoCarregado.getTentativas();
                        tabuleiro.exibir();
                    } else {
                        System.out.println("Não foi possível carregar o jogo.");
                    }
                    continue;
                }
                if (linha1 == -1) { // O jogador escolheu salvar o jogo
                    estadoJogo.salvarJogo(tabuleiro, tentativas, "estado_jogo.mem");
                    break;
                }
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
                    tentativas++;
                    System.out.println("Não é um par. As cartas serão viradas novamente.");
                    tabuleiro.exibir();
                }
            }
            if (tabuleiro.isVitoria()) {
                System.out.println("Parabéns! Você encontrou todos os pares!");
            }
            System.out.println("Número total de tentativas: " + tentativas);
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, insira números válidos.");
        }
    }
}
