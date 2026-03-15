package ex07;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> inteiros = new ArrayList<>();
        Calculador num = new Calculador(inteiros);
        inteiros.add(2.25);
        inteiros.add(5.6);
        inteiros.add(4.9);
        inteiros.add(4.6);

        System.out.println(num.getCalculated());
    }
}
