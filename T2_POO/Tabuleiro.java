import java.io.Serializable;
import java.util.Collections;
import java.util.ArrayList;

public class Tabuleiro implements Serializable {
    private int linhas; // dimensões do tabuleiro
    private int colunas;
    
    private Exibivel[][] cartas; // Matriz de cartas

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.cartas = new Exibivel[linhas][colunas];
    }

    public void inicializar(ArrayList<String> simbolos) {
        ArrayList<String> simbolosParaTabuleiro = new ArrayList<>();

        simbolosParaTabuleiro.addAll(simbolos);
        simbolosParaTabuleiro.addAll(simbolos); // DUPLICA

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
    public boolean verificarPar(int l1, int c1, int l2, int c2) {
        Exibivel carta1 = cartas[l1][c1];
        Exibivel carta2 = cartas[l2][c2];
        // Validação 1: O usuário escolheu exatamente a mesma coordenada duas vezes?
        if (l1 == l2 && c1 == c2) {
            System.out.println("Jogada inválida! Você não pode escolher a mesma carta duas vezes.");
            carta1.setVirada(false); // Garante que a carta volte a ser virada
            return false;
        }
        carta1.setVirada(!carta1.isVirada());
        carta2.setVirada(!carta2.isVirada());

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

    public boolean revelarCarta(int linha, int coluna) {
        if (cartas[linha][coluna].isVirada()) {
            System.out.println("Jogada inválida! Você escolheu uma carta que já está virada.");
            return false; // A carta já está virada
        }
        if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas) {
            return false;
        }
        cartas[linha][coluna].setVirada(true);
        return true;
    }

    public boolean isVitoria() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (!cartas[i][j].exibir().equals(cartas[i][j].getSimbolo())) {
                    return false; // Se encontrar alguma carta que não esteja virada, ainda não é vitória
                }
            }
        }
        return true; // Se todas as cartas estiverem viradas, é vitória
    }

    // Getters para acessar os atributos do tabuleiro
    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Exibivel[][] getCartas() {
        return cartas;
    }
}