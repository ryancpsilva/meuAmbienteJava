package ex01;

public class Main {
    public static void main(String[] args) {
        Carta carta1 = new Carta(0, 0, "A");
        Carta carta2 = new Carta(0, 1, "B");

        carta1.setVirada(true);
        
        System.out.println(carta1.exibir());
        System.out.println(carta2.exibir());
    }
}
