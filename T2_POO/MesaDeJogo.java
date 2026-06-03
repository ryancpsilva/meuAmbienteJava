import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MesaDeJogo implements Serializable {
    private int maxLinhas;
    private int maxColunas;
    private ElementoVisivel[][] malha;

    public MesaDeJogo(int linhas, int colunas) {
        this.maxLinhas = linhas;
        this.maxColunas = colunas;
        this.malha = new ElementoVisivel[linhas][colunas];
    }

    public void prepararMesa() {
        int quantidadePares = (maxLinhas * maxColunas) / 2;
        List<String> conjSimbolos = new ArrayList<>();
        
        for (int i = 0; i < quantidadePares; i++) {
            String letra = String.valueOf((char) ('A' + i));
            conjSimbolos.add(letra);
            conjSimbolos.add(letra); 
        }
        
        Collections.shuffle(conjSimbolos);

        int cursor = 0;
        for (int l = 0; l < maxLinhas; l++) {
            for (int c = 0; c < maxColunas; c++) {
                    malha[l][c] = new PecaTabuleiro(conjSimbolos.get(cursor));                
                cursor++;
            }
        }
    }

    public void imprimirMesa() {
        System.out.print("    ");
        for (int c = 0; c < maxColunas; c++) {
            System.out.printf("%02d  ", (c + 1));
        }
        System.out.println("\n   " + "----".repeat(maxColunas));

        for (int l = 0; l < maxLinhas; l++) {
            System.out.printf("%02d |", (l + 1));
            for (int c = 0; c < maxColunas; c++) {
                System.out.print(" " + malha[l][c].obterAparencia());
            }
            System.out.println();
        }
    }

    public boolean processarEscolha(int l, int c) {
        if (l < 0 || l >= maxLinhas || c < 0 || c >= maxColunas) return false;
        ElementoVisivel peca = malha[l][c];
        
        if (peca.estaExposta()) return false;
        
        peca.mudarStatusExposicao(true);
        return true;
    }

    public boolean analisarJogada(int l1, int c1, int l2, int c2) {
        if (l1 == l2 && c1 == c2) {
            malha[l1][c1].mudarStatusExposicao(false);
            return false;
        }

        ElementoVisivel p1 = malha[l1][c1];
        ElementoVisivel p2 = malha[l2][c2];

        if (p1.buscarSimbolo().equals(p2.buscarSimbolo())) {
            return true; // Deu match
        } else {
            p1.mudarStatusExposicao(false);
            p2.mudarStatusExposicao(false);
            return false; // Errou
        }
    }

    public boolean verificarConclusao() {
        for (int l = 0; l < maxLinhas; l++) {
            for (int c = 0; c < maxColunas; c++) {
                if (!malha[l][c].estaExposta()) return false;
            }
        }
        return true;
    }

    public int getMaxLinhas() { return maxLinhas; }
    public int getMaxColunas() { return maxColunas; }
}