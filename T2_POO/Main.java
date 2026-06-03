public class Main {

    public static void main(String[] args) {
        ConsoleInterativo console = new ConsoleInterativo();
        boolean rodando = true;

        while (rodando) {
            console.higienizarTela();
            console.mostrarAlerta("==================================");
            console.mostrarAlerta("      DESAFIO DE MEMÓRIA PRO      ");
            console.mostrarAlerta("==================================");
            console.mostrarAlerta("[1] Nova Batalha");
            console.mostrarAlerta("[2] Retomar Sessão Anterior");
            console.mostrarAlerta("[3] Hall da Fama (Ranking)");
            console.mostrarAlerta("[4] Encerrar Sistema");
            
            int escolha = console.solicitarInteiro("\nDefina sua ação: ");

            switch (escolha) {
                case 1:
                    configurarNovaBatalha(console);
                    break;
                case 2:
                    RodadaAtual rodadaSalva = SistemaDeArquivos.recuperarSessao(console);
                    if (rodadaSalva != null) {
                        console.pausar();
                        orquestrarJogo(console, rodadaSalva);
                    } else {
                        console.pausar();
                    }
                    break;
                case 3:
                    console.higienizarTela();
                    SistemaDeArquivos.imprimirPlacar(console);
                    console.pausar();
                    break;
                case 4:
                    console.mostrarAlerta("Finalizando a aplicação... Até mais!");
                    rodando = false;
                    break;
                default:
                    console.mostrarAlerta("Opção desconhecida.");
                    console.pausar();
            }
        }
    }

    private static void configurarNovaBatalha(ConsoleInterativo console) {
        console.higienizarTela();
        String alias = console.solicitarTexto("Insira seu apelido/nickname: ");
        Competidor comp = new Competidor(alias);

        console.mostrarAlerta("\nSelecione o nível de desafio:");
        console.mostrarAlerta("1 - Iniciante (4x4)");
        console.mostrarAlerta("2 - Intermediário (6x6)");
        console.mostrarAlerta("3 - Especialista (8x8)");
        
        int nivel = console.solicitarInteiro("Nível desejado: ");
        MesaDeJogo mesa;

        switch (nivel) {
            case 2: mesa = new MesaDeJogo(6, 6); break;
            case 3: mesa = new MesaDeJogo(8, 8); break;
            default: mesa = new MesaDeJogo(4, 4); break;
        }

        mesa.prepararMesa();
        RodadaAtual novaRodada = new RodadaAtual(comp, mesa, 0);
        orquestrarJogo(console, novaRodada);
    }

    private static void orquestrarJogo(ConsoleInterativo console, RodadaAtual rodada) {
        Competidor player = rodada.getCompetidor();
        MesaDeJogo mesa = rodada.getMesa();
        int acertosRealizados = rodada.getAcertosAtuais();

        while (true) {
            console.higienizarTela();
            mesa.imprimirMesa();
            console.mostrarAlerta("\n>>> Competidor: " + player.getNickname() + 
                                  " | Movimentos: " + player.getMovimentos() + 
                                  " | Score: " + player.getScore());

            int[] coord1 = console.obterCoordenadasVetor("Posição da 1ª peça (linha coluna) ou '0' p/ salvar: ");
            if (coord1[0] == 0) {
                SistemaDeArquivos.persistirSessao(new RodadaAtual(player, mesa, acertosRealizados), console);
                console.pausar();
                return; 
            }

            if (!mesa.processarEscolha(coord1[0] - 1, coord1[1] - 1)) {
                console.mostrarAlerta("Coordenada bloqueada ou inválida!");
                console.pausar();
                continue;
            }

            console.higienizarTela();
            mesa.imprimirMesa();

            int[] coord2 = console.obterCoordenadasVetor("Posição da 2ª peça (linha coluna): ");
            if (coord2[0] == 0) continue; 

            if (!mesa.processarEscolha(coord2[0] - 1, coord2[1] - 1)) {
                mesa.analisarJogada(coord1[0]-1, coord1[1]-1, coord1[0]-1, coord1[1]-1); 
                console.mostrarAlerta("Coordenada inválida!");
                console.pausar();
                continue;
            }

            console.higienizarTela();
            mesa.imprimirMesa();
            player.adicionarMovimento();

            if (mesa.analisarJogada(coord1[0] - 1, coord1[1] - 1, coord2[0] - 1, coord2[1] - 1)) {
                console.mostrarAlerta(">> EXCELENTE! Você formou um par! (+25 pts)");
                player.computarAcerto(25);
                acertosRealizados++;
            } else {
                console.mostrarAlerta(">> ERROU! Memorize e tente novamente.");
            }
            console.pausar();

            if (mesa.verificarConclusao()) {
                console.higienizarTela();
                console.mostrarAlerta("🏆 FIM DE JOGO! VOCÊ VENCEU! 🏆");
                console.mostrarAlerta("Apelido: " + player.getNickname());
                console.mostrarAlerta("Score Final: " + player.getScore());
                
                SistemaDeArquivos.registrarNoPlacar(player);
                console.mostrarAlerta("Seus dados foram computados no Hall da Fama!");
                console.pausar();
                break;
            }
        }
    }
}