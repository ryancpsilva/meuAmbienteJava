import java.util.Scanner;

public class ConsoleInterativo {
    private Scanner leitor;

    public ConsoleInterativo() {
        this.leitor = new Scanner(System.in);
    }

    public void pausar() {
        System.out.println("Pressione [ENTER] para avançar...");
        leitor.nextLine();
    }

    public void higienizarTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception ignored) {}
    }

    public void mostrarAlerta(String msg) {
        System.out.println(msg);
    }

    public String solicitarTexto(String prompt) {
        System.out.print(prompt);
        return leitor.nextLine().trim();
    }

    public int solicitarInteiro(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int valor = Integer.parseInt(leitor.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("-> Inválido. Insira apenas números inteiros.");
            }
        }
    }

    // Leitura inteligente de coordenadas
    public int[] obterCoordenadasVetor(String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = leitor.nextLine().trim();
            
            if (entrada.equals("0")) return new int[]{0, 0}; // Código de saída

            String[] partes = entrada.split(" ");
            if (partes.length >= 2) {
                try {
                    int linha = Integer.parseInt(partes[0]);
                    int coluna = Integer.parseInt(partes[1]);
                    return new int[]{linha, coluna};
                } catch (NumberFormatException ignored) {}
            }
            System.out.println("-> Formato incorreto. Digite LINHA e COLUNA separados por espaço. Ex: 2 4");
        }
    }
}