package lista02.ex01;

public class Carta {
    private int linha;
    private int coluna;
    private String simbolo;
    private boolean virada;

    // Construtores
    public Carta(int linha, int coluna){
        this.simbolo = "";
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public Carta(int linha, int coluna, String simbolo){
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = simbolo;
    }

    public String exibir() {
        if (virada) {
            return "[" + simbolo + "]";
        } else {
            return "[ X ]";
        }
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

    public boolean isVirada() {
        return virada;
    }

    public void setVirada(boolean virada) {
        this.virada = virada;
    }

}
