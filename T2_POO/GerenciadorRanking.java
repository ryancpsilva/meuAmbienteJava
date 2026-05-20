import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

public class GerenciadorRanking {
    private static final Path PATH = Paths.get("ranking.dat");

    // Adiciona o jogador, ordena o ranking e salva no arquivo
    public static void adicionarAoRanking(Jogador jogador) {
        ArrayList<Jogador> ranking = carregarRanking();
        ranking.add(jogador);
        
        // Ordena do menor número de tentativas para o maior
        ranking.sort(Comparator.comparingInt(Jogador::getTentativas));

        // Mantém apenas os 10 melhores (Top 10)
        if (ranking.size() > 10) {
            ranking = new ArrayList<>(ranking.subList(0, 10));
        }
        
        salvarRanking(ranking);
    }

    // Lê o arquivo e imprime o placar na tela
    public static void exibirRanking(Ui ui) {
        ArrayList<Jogador> ranking = carregarRanking();
        
        ui.exibirMensagem("\n=================================");
        ui.exibirMensagem("       MELHORES PLACARES (TOP 10)");
        ui.exibirMensagem("=================================");
        
        if (ranking.isEmpty()) {
            ui.exibirMensagem("Ainda não há placares registrados.");
        } else {
            for (int i = 0; i < ranking.size(); i++) {
                Jogador j = ranking.get(i);
                ui.exibirMensagem((i + 1) + "º Lugar - " + j.getNome() + " | Tentativas: " + j.getTentativas() + " | Pontos: " + j.getPontuacao());
            }
        }
        ui.exibirMensagem("=================================\n");
    }

    // Método privado para salvar a lista no arquivo (NIO)
    private static void salvarRanking(ArrayList<Jogador> ranking) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(PATH))) {
            oos.writeObject(ranking);
        } catch (IOException e) {
            System.out.println("Erro ao salvar ranking: " + e.getMessage());
        }
    }

    // Método privado para carregar a lista do arquivo (NIO)
    @SuppressWarnings("unchecked")
    private static ArrayList<Jogador> carregarRanking() {
        if (!Files.exists(PATH)) {
            return new ArrayList<>(); // Retorna uma lista vazia se o arquivo ainda não existir
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(PATH))) {
            return (ArrayList<Jogador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar ranking: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}