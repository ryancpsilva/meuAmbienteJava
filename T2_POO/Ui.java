import java.util.Scanner;

public class Ui {
    Scanner scanner = new Scanner(System.in);

    public void esperarEnter() {
        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

    public void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                new ProcessBuilder("clear")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
