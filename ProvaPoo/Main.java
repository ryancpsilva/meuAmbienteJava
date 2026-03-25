import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaClientes lista = new ListaClientes();
        int opcao;

        do {
            limparTela();

            System.out.println("=================================");
            System.out.println("      SISTEMA DE PEDIDOS");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Fazer pedido");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            limparTela();

            switch (opcao) {
                case 1:
                    System.out.println("=== Cadastro de Cliente ===");
                    lista.cadastrarCliente();
                    pausar(sc);
                    break;

                case 2:
                    System.out.println("=== Lista de Clientes ===");
                    lista.listarClientes();
                    pausar(sc);
                    break;

                case 3:
                    System.out.println("=== Fazer Pedido ===");
                    System.out.println("Funcionalidade em construção...");
                    pausar(sc);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    pausar(sc);
            }

        } while (opcao != 0);

        sc.close();
    }

    // Simula limpeza de tela
    public static void limparTela() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    // Pausa até o usuário apertar ENTER
    public static void pausar(Scanner sc) {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }
}