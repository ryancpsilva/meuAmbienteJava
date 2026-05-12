public class Main {

    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(4, 4);
        String[] simbolos = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H"};
        Carta carta1 = new Carta(0, 0, "A");
        Carta carta2 = new Carta(0, 1, "B");

        System.out.println(carta1);
        System.out.println(carta2);

        carta1.setVirada(true);

        System.out.println("Exibindo cartas:");
        System.out.println(carta1.exibir());
        System.out.println(carta2.exibir());

        tabuleiro.inicializar(simbolos);
        System.out.println("Tabuleiro inicializado:");

        tabuleiro.exibir();
    }
}
