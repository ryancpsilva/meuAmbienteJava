package ex07;

import java.util.ArrayList;

class Calculador {

    // declaração do array
    ArrayList<Double> list = new ArrayList<>();
    Double contador = 0.0;

    // construtor
    Calculador(ArrayList<Double> list) {
        this.list = list;
    }

    // função
    Double getCalculated() {
        // lógica
        for (int i = 0; i < list.size(); i++) {
            contador += list.get(i);
        }
        return contador;
    }
}