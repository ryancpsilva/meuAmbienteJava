package ex02;

import java.util.ArrayList;
import java.util.Collections;

public class Tabuleiro {
    private int linhas; // dimensões do tabuleiro
    private int colunas;
    private Carta[][] cartas; // Matriz de cartas

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.cartas = new Carta[linhas][colunas];
    }

    public void inicializar(String[] simbolos) {
        ArrayList<String> simbolosParaTabuleiro = new ArrayList<>();

        simbolosParaTabuleiro.addAll(java.util.Arrays.asList(simbolos));
        simbolosParaTabuleiro.addAll(java.util.Arrays.asList(simbolos)); // DUPLICA

        Collections.shuffle(simbolosParaTabuleiro); // Embaralha os símbolos
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                cartas[i][j] = new Carta(i, j, simbolosParaTabuleiro.get(index));
                index++;
            }
        }

    }
    public void exibir() {
        // Exibe os números das colunas
        for (int j = 0; j < colunas; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();
    
        // Exibe o tabuleiro com as cartas e os números das linhas
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(cartas[i][j].exibir() + " ");
            }
            System.out.println("| " + (i + 1));
        }
    }
}
