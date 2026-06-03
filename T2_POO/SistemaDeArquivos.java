import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SistemaDeArquivos {
    private static final String ARQ_SAVE = "backup_sessao.bin";
    private static final String ARQ_RANK = "lideres_historico.bin";

    public static void persistirSessao(RodadaAtual rodada, ConsoleInterativo console) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(ARQ_SAVE)))) {
            oos.writeObject(rodada);
            console.mostrarAlerta("\n[!] Progresso gravado com sucesso. Você pode voltar depois.");
        } catch (IOException e) {
            console.mostrarAlerta("[ERRO] Falha ao gravar progresso no disco.");
        }
    }

    public static RodadaAtual recuperarSessao(ConsoleInterativo console) {
        Path caminho = Paths.get(ARQ_SAVE);
        if (!Files.exists(caminho)) {
            console.mostrarAlerta("\n[!] Não há nenhuma sessão anterior salva no sistema.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(caminho))) {
            return (RodadaAtual) ois.readObject();
        } catch (Exception e) {
            console.mostrarAlerta("[ERRO] Arquivo de save corrompido ou inacessível.");
            return null;
        }
    }

    public static void registrarNoPlacar(Competidor comp) {
        List<Competidor> lista = new ArrayList<>();
        Path caminho = Paths.get(ARQ_RANK);

        if (Files.exists(caminho)) {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(caminho))) {
                lista = (List<Competidor>) ois.readObject();
            } catch (Exception ignored) {}
        }

        lista.add(comp);
        lista.sort(Comparator.comparingInt(Competidor::getMovimentos));

        if (lista.size() > 10) {
            lista = lista.subList(0, 10);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(caminho))) {
            oos.writeObject(lista);
        } catch (IOException ignored) {}
    }

    public static void imprimirPlacar(ConsoleInterativo console) {
        Path caminho = Paths.get(ARQ_RANK);
        console.mostrarAlerta("\n--- TOP 10 COMPETIDORES ---");
        
        if (!Files.exists(caminho)) {
            console.mostrarAlerta("Nenhum registro encontrado.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(caminho))) {
            List<Competidor> lista = (List<Competidor>) ois.readObject();
            for (int i = 0; i < lista.size(); i++) {
                Competidor c = lista.get(i);
                console.mostrarAlerta(String.format("%02d. %s -> Movimentos: %d | Pontos: %d", 
                    (i + 1), c.getNickname(), c.getMovimentos(), c.getScore()));
            }
        } catch (Exception e) {
            console.mostrarAlerta("[ERRO] Falha ao ler os líderes.");
        }
    }
}