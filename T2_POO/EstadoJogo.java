import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class EstadoJogo {
    public void salvarJogo(Partida partida) {
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

        public Partida carregarJogo() {
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