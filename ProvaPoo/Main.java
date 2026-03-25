import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaClientes lista = new ListaClientes();
        int opcao;
        do {
            limparTela();
            System.out.println("=".repeat(33));
            System.out.println("        SISTEMA DE PEDIDOS");
            System.out.println("=".repeat(33));
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
                    System.out.print("Digite o nome do cliente: ");
                    if (lista.cadastrarCliente()) {
                        System.out.println("Cliente cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar cliente!");
                    }
                    pausar(sc);
                    break;

                case 2:
                    System.out.println("=== Lista de Clientes ===");
                    System.out.println("Total de clientes: " + lista.getSize());
                    lista.listarClientes();
                    pausar(sc);
                    break;

                case 3:
                    System.out.println("=== Fazer Pedido ===");
                    System.out.println("Qual cliente deseja fazer o pedido? (ID)");
                    int idCliente = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                    Pedido pedido = new Pedido(lista.getClienteById(idCliente));
                    
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