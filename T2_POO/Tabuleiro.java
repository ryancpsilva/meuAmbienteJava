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
        Collections.shuffle(java.util.Arrays.asList(simbolos)); // Embaralha os símbolos
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                cartas[i][j] = new Carta(i, j, simbolos[index]);
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
}
