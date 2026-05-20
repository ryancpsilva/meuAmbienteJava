import java.util.Scanner;
import java.util.ArrayList;
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
        Ui ui = new Ui();

        while (opcao != 4) {
            ui.limparConsole();
            ui.exibirMensagem("\n=================================");
            ui.exibirMensagem("       JOGO DA MEMÓRIA           ");
            ui.exibirMensagem("=================================");
            ui.exibirMensagem("1. Iniciar novo jogo");
            ui.exibirMensagem("2. Carregar jogo salvo");
            ui.exibirMensagem("3. Melhores placares");
            ui.exibirMensagem("4. Sair");
            ui.exibirMensagem("Escolha uma opção: ");

            try {
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        ui.limparConsole();
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
                        ui.exibirMensagem("\n[Funcionalidade em desenvolvimento: Melhores Placares]");
                        break;
                    case 4:
                        ui.exibirMensagem("\nSaindo do jogo... Até a próxima!");
                        break;
                    default:
                        ui.exibirMensagem("\n[ERRO] Opção inválida! Escolha um número entre 1 e 4.");
                }
            } catch (InputMismatchException e) {
                ui.exibirMensagem("\n[ERRO] Por favor, digite um número válido.");
                sc.nextLine();
            }
        }

        sc.close();
    }

    public static void iniciarNovoJogo(Scanner sc) {
        Ui ui = new Ui();
        ui.exibirMensagem("\nDigite o nome do jogador: ");
        sc.nextLine(); // Limpa o buffer do scanner
        String nome = sc.nextLine();
        Jogador jogador = new Jogador(nome);

        ui.exibirMensagem("Gostaria de jogar em um tabuleiro Fácil (4x4, 8 pares), Médio (6x6, 18 pares) ou Difícil (8x8, 32 pares)?");
        ui.exibirMensagem("");                
        ui.exibirMensagem("Digite 1 para Fácil, 2 para Médio ou 3 para Difícil: ");

        int dificuldade = sc.nextInt();
        Tabuleiro tabuleiro;

        switch (dificuldade) {
            case 1:
                tabuleiro = new Tabuleiro(4, 4);
                break;
            case 2:
                tabuleiro = new Tabuleiro(6, 6);
                break;
            case 3:
                tabuleiro = new Tabuleiro(8, 8);
                break;

            default:
                ui.exibirMensagem("\n[ERRO] Dificuldade inválida! Usando Fácil.");
                tabuleiro = new Tabuleiro(4, 4);
                break;

        }

        ArrayList<String> simbolos = new ArrayList<>();

        for (int i = 0; i < tabuleiro.getLinhas() * tabuleiro.getColunas() / 2; i++) {
            simbolos.add(Character.toString((char) ('A' + i)));
        }

        tabuleiro.inicializar(simbolos);
        ui.exibirMensagem("\n--- NOVO JOGO INICIADO ---");
        ui.exibirMensagem("Boa sorte, " + jogador.getNome() + "!");

        // Cria uma nova partida com 0 pares encontrados e envia para o loop principal
        Partida novaPartida = new Partida(jogador, tabuleiro, 0);
        executarPartida(sc, novaPartida);
    }

    // Novo método que concentra o loop de jogadas
    public static void executarPartida(Scanner sc, Partida partida) {
        Ui ui = new Ui();
        ui.limparConsole();
        // Extrai os dados do objeto Partida
        Jogador jogador = partida.getJogador();
        Tabuleiro tabuleiro = partida.getTabuleiro();
        int paresEncontrados = partida.getParesEncontrados();

        while (true) {
            ui.exibirMensagem("\n--- Status do Tabuleiro ---");
            tabuleiro.exibir();
            ui.exibirMensagem(
                    "\nPontuação atual: " + jogador.getPontuacao() + " | Tentativas: " + jogador.getTentativas());
            ui.exibirMensagem("--- Sua vez de jogar! ---");

            try {
                ui.exibirMensagem("Digite a linha da 1ª carta (1-" + tabuleiro.getLinhas()
                        + ") ou digite 0 para SALVAR e SAIR: ");
                int linha1 = sc.nextInt();

                // Lógica de Salvamento e saída do jogo
                if (linha1 == 0) {
                    Partida partidaAtual = new Partida(jogador, tabuleiro, paresEncontrados);
                    salvarJogo(partidaAtual);
                    return; // Encerra o método executarPartida e volta para o menu principal
                }

                ui.exibirMensagem("Digite a coluna da 1ª carta (1-" + tabuleiro.getColunas() + "): ");
                int coluna1 = sc.nextInt();
                if (!tabuleiro.revelarCarta(linha1 - 1, coluna1 - 1)) { // Revela a primeira carta escolhida
                    ui.limparConsole();
                    ui.exibirMensagem("\n[ERRO] Jogada inválida! Tente novamente.");
                    continue;
                }
                ui.limparConsole();
                ui.exibirMensagem("\n--- Status do Tabuleiro ---");
                tabuleiro.exibir(); // Exibe o tabuleiro atualizado com a primeira carta revelada
                ui.exibirMensagem("Digite a linha da 2ª carta (1-" + tabuleiro.getLinhas() + "): ");
                int linha2 = sc.nextInt();
                ui.exibirMensagem("Digite a coluna da 2ª carta (1-" + tabuleiro.getColunas() + "): ");
                int coluna2 = sc.nextInt();
                if (!tabuleiro.revelarCarta(linha2 - 1, coluna2 - 1)) { // Revela a segunda carta escolhida
                    ui.limparConsole();
                    ui.exibirMensagem("\n[ERRO] Jogada inválida! Tente novamente.");
                    continue;
                }
                ui.limparConsole();
                ui.exibirMensagem("\n--- Status do Tabuleiro ---");
                tabuleiro.exibir(); // Exibe o tabuleiro atualizado com a segunda carta revelada

                // Registra a tentativa no objeto do jogador
                jogador.registrarTentativa();
                ui.exibirMensagem("\n>>> Tentativa número: " + jogador.getTentativas() + " <<<");

                boolean achouPar = tabuleiro.verificarPar(linha1 - 1, coluna1 - 1, linha2 - 1, coluna2 - 1);
                ui.esperarEnter(); // Pausa para o jogador ver o resultado antes de limpar a tela
                ui.limparConsole();

                if (achouPar) {
                    paresEncontrados++;
                    jogador.adicionarPontuacao(10); // Adiciona 10 pontos por par encontrado
                    ui.exibirMensagem("+10 Pontos!");
                }

                if (tabuleiro.isVitoria()) {
                    ui.exibirMensagem("\n🎉 VITÓRIA! Você encontrou todos os pares!");
                    ui.exibirMensagem("=== RESUMO DA PARTIDA ===");
                    ui.exibirMensagem(jogador.toString());
                    break; // Sai do loop de jogo e volta ao menu
                }

            } catch (InputMismatchException e) {
                ui.exibirMensagem("\n[ERRO] Entrada inválida! Por favor, digite apenas números.");
                sc.nextLine();
            } catch (Exception e) {
                ui.exibirMensagem("\n[ERRO] Ocorreu um problema inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    public static void salvarJogo(Partida partida) {
        Ui ui = new Ui();
        Path path = Paths.get("save_memoria.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(partida);
            ui.exibirMensagem("\n[SUCESSO] Jogo salvo com sucesso!");
        } catch (IOException e) {
            ui.exibirMensagem("\n[ERRO] Não foi possível salvar o jogo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Partida carregarJogo() {
        Ui ui = new Ui();
        Path path = Paths.get("save_memoria.dat");

        if (!Files.exists(path)) {
            ui.exibirMensagem("\n[AVISO] Nenhum jogo salvo encontrado.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Partida partida = (Partida) ois.readObject();
            ui.exibirMensagem("\n[SUCESSO] Jogo carregado com sucesso! Retomando partida de onde parou...");
            return partida;
        } catch (IOException | ClassNotFoundException e) {
            ui.exibirMensagem("\n[ERRO] Não foi possível carregar o jogo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}