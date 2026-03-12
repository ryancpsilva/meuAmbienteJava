import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<>();

        frutas.add("banana");
        frutas.add("pera");
        frutas.add("abacate");
        frutas.add("ameixa");
        frutas.add("manga");
        // [banana, pera, abacate, ameixa, manga]
        System.out.println(frutas);
        
        frutas.remove("ameixa");
        System.out.println(frutas);
        // [banana, pera, abacate, manga]

    }
}
