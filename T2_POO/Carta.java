import java.io.Serializable;

public class Carta implements Serializable {
    private int linha; // posição da carta no tabuleiro
    private int coluna;
    private String simbolo; // Conteúdo da carta
    private boolean virada; // Indica se a carta está revelada ou não

    // Construtor padrão
    public Carta(int linha, int coluna, String simbolo) {
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = simbolo;
    }

    public Carta(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = ""; // Inicializa o símbolo como vazio
    }

    // Getters e Setters
    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String exibir() {
        if (virada) {
            return simbolo; // Retorna o símbolo se a carta estiver virada
        } else {
            return "X"; // Retorna "X" se a carta estiver virada para baixo
        }
    }

    public void setVirada(boolean virada) {
        this.virada = virada;
    }

    public String toString() {
        return "Carta{" +
                "linha=" + linha +
                ", coluna=" + coluna +
                ", simbolo='" + simbolo + '\'' +
                ", virada=" + virada +
                '}';
    }
}