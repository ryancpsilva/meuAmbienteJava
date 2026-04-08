import java.util.ArrayList;

public class ListaPedido {
    ArrayList<Pedido> list = new ArrayList<>();
    ArrayList<Integer> pedidosId = new ArrayList<>(); // NOVA LINHA: Lista para armazenar os IDs dos pedidos

    public void adicionarPedido(Pedido pedido) { // Adiciona um pedido à lista de pedidos
        list.add(pedido);
        pedidosId.add(pedido.getId()); // Adiciona o ID do pedido à lista de IDs
    }

    public void listarPedidos() { // Lista os pedidos cadastrados
        for (Pedido p : list) {
            System.out.println("-".repeat(28));
            System.out.println("ID do Cliente: " + p.getId());
            System.out.println("Nome do Cliente: " + p.getCliente().getNome());
            System.out.println("Itens do Pedido:");
            for (Item i : p.getItens()) {
                System.out.println(
                        "  - " + i.getNome() + " | Quantidade: " + i.getQuantidade() + " | Preço: R$ " + i.getPreco());
            }
            // NOVA LINHA ABAIXO: Chama o método que criamos para exibir o total
            System.out.println("Total do Pedido: R$ " + p.calcularTotal());
            System.out.println("-".repeat(28));
        }
    }

    public void listarPedidosPorCliente(int idCliente) { // Lista os pedidos de um cliente específico
        if (!pedidosId.contains(idCliente)) {
            System.out.println("Nenhum pedido encontrado para o ID do cliente: " + idCliente);
        }
        for (Pedido p : list) {
            if (p.getId() == idCliente) { // Verifica se o ID do cliente está na lista de IDs
                System.out.println("-".repeat(28));
                System.out.println("ID do Cliente: " + p.getId());
                System.out.println("Nome do Cliente: " + p.getCliente().getNome());
                System.out.println("-".repeat(28));
                System.out.println("Itens do Pedido:");
                for (Item i : p.getItens()) {
                    System.out.println("  - " + i.getNome() + " | Quantidade: " + i.getQuantidade() + " | Preço: R$ "
                            + i.getPreco());
                }
                System.out.println("Total do Pedido: R$ " + p.calcularTotal());
                System.out.println("-".repeat(28));
            }
        }
    }
}
