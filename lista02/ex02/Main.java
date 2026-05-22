package ex02;

public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(4, 4);

        String[] simbolos = {"A", "B", "C", "D", "E", "F", "G", "H"};
        tabuleiro.inicializar(simbolos);
        tabuleiro.exibir();
    }
}
