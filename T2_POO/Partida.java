import java.io.Serializable;

public class Partida implements Serializable {
    private Jogador jogador;
    private Tabuleiro tabuleiro;
    private int paresEncontrados;

    public Partida(Jogador jogador, Tabuleiro tabuleiro, int paresEncontrados) {
        this.jogador = jogador;
        this.tabuleiro = tabuleiro;
        this.paresEncontrados = paresEncontrados;
    }

    public Jogador getJogador() { return jogador; }
    public Tabuleiro getTabuleiro() { return tabuleiro; }
    public int getParesEncontrados() { return paresEncontrados; }
}