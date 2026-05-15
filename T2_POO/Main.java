import java.util.Scanner;
import java.util.InputMismatchException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

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
                        Partida partidaCarregada = carregarJogo();
                        if (partidaCarregada != null) {
                            // Se carregou com sucesso, passa a partida para o loop do jogo
                            executarPartida(sc, partidaCarregada);
                        }
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
        System.out.print("\nDigite o nome do jogador: ");
        String nome = sc.next();
        Jogador jogador = new Jogador(nome);

        Tabuleiro tabuleiro = new Tabuleiro(4, 4);
        String[] simbolos = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H"};
        
        tabuleiro.inicializar(simbolos);
        
        System.out.println("\n--- NOVO JOGO INICIADO ---");
        System.out.println("Boa sorte, " + jogador.getNome() + "!");

        // Cria uma nova partida com 0 pares encontrados e envia para o loop principal
        Partida novaPartida = new Partida(jogador, tabuleiro, 0);
        executarPartida(sc, novaPartida);
    }

    // Novo método que concentra o loop de jogadas
    public static void executarPartida(Scanner sc, Partida partida) {
        // Extrai os dados do objeto Partida
        Jogador jogador = partida.getJogador();
        Tabuleiro tabuleiro = partida.getTabuleiro();
        int paresEncontrados = partida.getParesEncontrados();
        int totalPares = 8; // Considerando o tabuleiro 4x4 padrão

        while (true) {
            System.out.println("\n--- Status do Tabuleiro ---");
            tabuleiro.exibir();
            System.out.println("\nPontuação atual: " + jogador.getPontuacao() + " | Tentativas: " + jogador.getTentativas());
            System.out.println("--- Sua vez de jogar! ---");
            
            try {
                System.out.print("Digite a linha da 1ª carta (1-4) ou digite 0 para SALVAR e SAIR: ");
                int linha1 = sc.nextInt(); 

                // Lógica de Salvamento e saída do jogo
                if (linha1 == 0) {
                    Partida partidaAtual = new Partida(jogador, tabuleiro, paresEncontrados);
                    salvarJogo(partidaAtual);
                    return; // Encerra o método executarPartida e volta para o menu principal
                }

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

                // Registra a tentativa no objeto do jogador
                jogador.registrarTentativa();
                System.out.println("\n>>> Tentativa número: " + jogador.getTentativas() + " <<<");

                boolean achouPar = tabuleiro.processarJogada(linha1 - 1, coluna1 - 1, linha2 - 1, coluna2 - 1);

                if (achouPar) {
                    paresEncontrados++;
                    jogador.adicionarPontuacao(10); // Adiciona 10 pontos por par encontrado
                    System.out.println("+10 Pontos!");
                }

                if (paresEncontrados == totalPares) {
                    System.out.println("\n🎉 VITÓRIA! Você encontrou todos os pares!");
                    System.out.println("=== RESUMO DA PARTIDA ===");
                    System.out.println(jogador.toString()); 
                    break; // Sai do loop de jogo e volta ao menu
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
    public static void salvarJogo(Partida partida) {
        Path path = Paths.get("save_memoria.dat"); 
        
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(partida); 
            System.out.println("\n[SUCESSO] Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("\n[ERRO] Não foi possível salvar o jogo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static Partida carregarJogo() {
        Path path = Paths.get("save_memoria.dat"); 
        
        if (!Files.exists(path)) {
            System.out.println("\n[AVISO] Nenhum jogo salvo encontrado.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Partida partida = (Partida) ois.readObject(); 
            System.out.println("\n[SUCESSO] Jogo carregado com sucesso! Retomando partida de onde parou...");
            return partida;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\n[ERRO] Não foi possível carregar o jogo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}