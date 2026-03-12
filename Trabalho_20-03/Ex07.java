import java.util.ArrayList;

public class Ex07 {
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

class Calculador {

    //declaração do array
    ArrayList<Double> list = new ArrayList<>();
    Double contador = 0.0;

    //construtor
    Calculador (ArrayList<Double> list){
        this.list = list;
    }

    //função
    Double getCalculated () {
        //lógica
        for(int i = 0; i < list.size(); i++){
            contador += list.get(i);
        }
        return contador;
    }
}