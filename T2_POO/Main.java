import java.util.Scanner;
import java.util.InputMismatchException; // Importante para o tratamento de erros

public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(4, 4);
        String[] simbolos = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H"};
        
        tabuleiro.inicializar(simbolos);
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Status do Tabuleiro ---");
            tabuleiro.exibir();
            
            System.out.println("\n--- Sua vez de jogar! ---");
            
            try {
                System.out.print("Digite a linha da 1ª carta (1-4): ");
                int linha1 = sc.nextInt(); 
                System.out.print("Digite a coluna da 1ª carta (1-4): ");
                int coluna1 = sc.nextInt(); 

                System.out.print("Digite a linha da 2ª carta (1-4): ");
                int linha2 = sc.nextInt(); 
                System.out.print("Digite a coluna da 2ª carta (1-4): ");
                int coluna2 = sc.nextInt(); 
                
                // Validação 1: O número está fora dos limites do tabuleiro (1 a 4)?
                if (linha1 < 1 || linha1 > 4 || coluna1 < 1 || coluna1 > 4 || 
                    linha2 < 1 || linha2 > 4 || coluna2 < 1 || coluna2 > 4) {
                    
                    System.out.println("\n[ERRO] Coordenada inválida! Você deve digitar números entre 1 e 4.");
                    continue; 
                }

                // Se passou na validação dos números, envia para o tabuleiro
                tabuleiro.processarJogada(linha1 - 1, coluna1 - 1, linha2 - 1, coluna2 - 1);

            } catch (InputMismatchException e) {
                // Tratamento de Erro: O usuário digitou uma letra ou símbolo em vez de número
                System.out.println("\n[ERRO] Entrada inválida! Por favor, digite apenas números.");
                
                // Essa linha limpa a "sujeira" (a letra) que ficou presa no Scanner
                // Se não colocar isso, o código entra em um loop infinito de erro!
                sc.nextLine(); 
                
            } catch (Exception e) {
                // Captura qualquer outro erro inesperado
                System.out.println("\n[ERRO] Ocorreu um problema inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}