import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaClientes lista = new ListaClientes();
        ListaPedido listaPedidos = new ListaPedido(); // NOVA LINHA: Instanciando a lista de pedidos
        int opcao;
        do {
            limparTela();
            System.out.println("=".repeat(33));
            System.out.println("        SISTEMA DE PEDIDOS");
            System.out.println("=".repeat(33));
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Fazer pedido");
            System.out.println("4 - Listar pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = sc.nextInt();
                sc.nextLine(); // limpar buffer
            } catch (Exception e) {
                opcao = -1; // Opção inválida
                sc.nextLine(); // limpar buffer
            }

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
                    try {
                        int idCliente = sc.nextInt();
                        sc.nextLine(); // limpar buffer

                        Cliente clienteEncontrado = lista.getClienteById(idCliente);
                        if (clienteEncontrado == null) {
                            System.out.println("Cliente não encontrado! Cadastre o cliente primeiro.");
                            pausar(sc);
                            break;
                        } else {
                            // Cria o pedido associado ao cliente encontrado
                            Pedido pedido = new Pedido(clienteEncontrado);

                            char continuar;
                            do {
                                // Chama a função que pede nome, preço e quantidade do item
                                boolean itemAdicionado = pedido.cadastrarPedido();

                                if (itemAdicionado) {
                                    System.out.print("Deseja adicionar mais um item a este pedido? (S/N): ");
                                    continuar = sc.nextLine().toLowerCase().charAt(0);
                                } else {
                                    // Se deu erro, volta ao inicio do menu para evitar adicionar um item inválido
                                    System.out.print("Erro ao adicionar item! Voltando ao menu.");
                                    break;
                                }
                            } while (continuar == 's');

                            // REGRA: Um pedido deve conter pelo menos um item.
                            if (pedido.getItens().size() > 0) {
                                listaPedidos.adicionarPedido(pedido); // Salva o pedido na memória!
                                System.out.println("\nPedido finalizado e salvo com sucesso!");
                                System.out.println("Valor total do pedido: R$ " + pedido.calcularTotal());
                            } else {
                                System.out.println("\nPedido cancelado, pois não possui nenhum item válido.");
                            }

                            pausar(sc);
                            break;
                        }
                    } catch (Exception e) {
                        System.out
                                .println("Entrada inválida! Certifique-se de digitar um número para o ID do cliente.");
                        sc.nextLine(); // limpar buffer
                        pausar(sc);
                        break;
                    }

                case 4:
                    System.out.println("=== Lista de Pedidos ===");
                    // Verifica se existem pedidos antes de tentar listar
                    try {
                        System.out.println("Deseja listar os pedidos de um cliente específico? (S/N): ");
                        char listarPorCliente = sc.nextLine().toLowerCase().charAt(0);

                        if (listarPorCliente == 's') {
                            System.out.print("Digite o ID do cliente: ");
                            int idClienteFiltro = sc.nextInt();
                            sc.nextLine(); // limpar buffer
                            listaPedidos.listarPedidosPorCliente(idClienteFiltro);
                        } else {

                            if (listaPedidos.list.isEmpty()) {
                                System.out.println("Nenhum pedido cadastrado no momento.");
                            } else {
                                listaPedidos.listarPedidos(); // Chama o método da ListaPedido
                            }
                        }
                        pausar(sc);
                        break;
                    } catch (Exception e) {
                        System.out
                                .println("Entrada inválida! Certifique-se de digitar um número para o ID do cliente.");
                        sc.nextLine(); // limpar buffer
                        pausar(sc);
                        break;
                    }

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