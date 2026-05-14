import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(4, 4);
        String[] simbolos = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H"};
        
        tabuleiro.inicializar(simbolos);
        System.out.println("Tabuleiro inicializado:");
        tabuleiro.exibir();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n--- Sua vez de jogar! ---");
        
        // le as coordenadas da primeira carta
        System.out.print("Digite a linha da 1ª carta: ");
        int linha1 = sc.nextInt(); 
        System.out.print("Digite a coluna da 1ª carta: ");
        int coluna1 = sc.nextInt(); 

        // le as coordenadas da segunda carta
        System.out.print("Digite a linha da 2ª carta: ");
        int linha2 = sc.nextInt(); 
        System.out.print("Digite a coluna da 2ª carta: ");
        int coluna2 = sc.nextInt(); 
        
        System.out.println("Você quer virar as cartas nas posições: (" + linha1 + "," + coluna1 + ") e (" + linha2 + "," + coluna2 + ")");
        
        sc.close();
    }
}