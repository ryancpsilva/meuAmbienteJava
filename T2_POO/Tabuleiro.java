import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Tabuleiro {
    private int linhas; // dimensões do tabuleiro
    private int colunas;
    private Carta[][] cartas; // Matriz de cartas

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.cartas = new Carta[linhas][colunas];
    }

    public void inicializar(ArrayList<String>simbolos) {
        
        Collections.shuffle(java.util.Arrays.asList(simbolos)); // Embaralha os símbolos
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                cartas[i][j] = new Carta(i, j, simbolos.get(index));
                index++;
            }
        }
    }
    
    public void exibir() {
        for (int j = 0; j < colunas; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(cartas[i][j].exibir() + " ");
            }
            System.out.println("| " + (i + 1));
        }
    }

    public boolean processarJogada(int l1, int c1, int l2, int c2) {
        // Validação 1: O usuário escolheu exatamente a mesma coordenada duas vezes?
        if (l1 == l2 && c1 == c2) {
            System.out.println("Jogada inválida! Você não pode escolher a mesma carta duas vezes.");
            return false;
        }

        Carta carta1 = cartas[l1][c1];
        Carta carta2 = cartas[l2][c2];

        // Validação 2: Alguma das cartas escolhidas já está virada para cima?
        if (carta1.exibir().equals(carta1.getSimbolo()) && !carta1.exibir().equals("X") || 
            carta2.exibir().equals(carta2.getSimbolo()) && !carta2.exibir().equals("X")) {
            // Se a carta já estiver mostrando o símbolo, é porque já foi virada
            System.out.println("Jogada inválida! Você escolheu uma carta que já está virada.");
            return false;
        }

        // Se passou pelas validações, vira as cartas e continua a lógica
        carta1.setVirada(true);
        carta2.setVirada(true);

        System.out.println("\nCartas reveladas:");
        exibir();

        if (carta1.getSimbolo().equals(carta2.getSimbolo())) {
            System.out.println("Parabéns! Você encontrou um par!");
            return true;
        } else {
            System.out.println("Ah, não formam um par. Escondendo as cartas novamente...");
            carta1.setVirada(false);
            carta2.setVirada(false);
            return false;
        }
    }
}
