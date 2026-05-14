import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        // Loop principal do Menu
        while (opcao != 4) {
            System.out.println("\n=================================");
            System.out.println("       JOGO DA MEMÓRIA           ");
            System.out.println("=================================");
            System.out.println("1. Iniciar novo jogo");
            System.out.println("2. Carregar jogo salvo");
            System.out.println("3. Melhores placares");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        iniciarNovoJogo(sc); 
                        break;
                    case 2:
                        System.out.println("\n[Funcionalidade em desenvolvimento: Carregar Jogo]");
                        break;
                    case 3:
                        System.out.println("\n[Funcionalidade em desenvolvimento: Melhores Placares]");
                        break;
                    case 4:
                        System.out.println("\nSaindo do jogo... Até a próxima!");
                        break;
                    default:
                        System.out.println("\n[ERRO] Opção inválida! Escolha um número entre 1 e 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO] Por favor, digite um número válido.");
                sc.nextLine(); 
            }
        }
        
        sc.close(); 
    }

    public static void iniciarNovoJogo(Scanner sc) {
        Tabuleiro tabuleiro = new Tabuleiro(4, 4);
        String[] simbolos = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H"};
        
        tabuleiro.inicializar(simbolos);
        
        int tentativas = 0;
        int paresEncontrados = 0;
        int totalPares = 8;
        
        System.out.println("\n--- NOVO JOGO INICIADO ---");

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
                
                if (linha1 < 1 || linha1 > 4 || coluna1 < 1 || coluna1 > 4 || 
                    linha2 < 1 || linha2 > 4 || coluna2 < 1 || coluna2 > 4) {
                    System.out.println("\n[ERRO] Coordenada inválida! Você deve digitar números entre 1 e 4.");
                    continue; 
                }

                tentativas++;
                System.out.println("\n>>> Tentativa número: " + tentativas + " <<<");

                boolean achouPar = tabuleiro.processarJogada(linha1 - 1, coluna1 - 1, linha2 - 1, coluna2 - 1);

                if (achouPar) {
                    paresEncontrados++; 
                }

                if (paresEncontrados == totalPares) {
                    System.out.println("\n🎉 VITÓRIA! Você encontrou todos os pares!");
                    System.out.println("Total de tentativas: " + tentativas);
                    break; 
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO] Entrada inválida! Por favor, digite apenas números.");
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("\n[ERRO] Ocorreu um problema inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}