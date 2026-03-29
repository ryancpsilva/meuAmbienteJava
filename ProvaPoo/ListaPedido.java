import java.util.ArrayList;

public class ListaPedido {
    ArrayList<Pedido> list = new ArrayList<>();   

    public void adicionarPedido(Pedido pedido) { //Adiciona um pedido à lista de pedidos
        list.add(pedido);
    }
    
    public void listarPedidos() { //Lista os pedidos cadastrados
        for (Pedido p : list) {
            System.out.println("-".repeat(28));
            System.out.println("ID do Cliente: " + p.getId());
            System.out.println("Nome do Cliente: " + p.getCliente().getNome());
            System.out.println("Itens do Pedido:");
            for (Item i : p.getItens()) {
                System.out.println("  - " + i.getNome() + " | Quantidade: " + i.getQuantidade() + " | Preço: R$ " + i.getPreco());
            }
            // NOVA LINHA ABAIXO: Chama o método que criamos para exibir o total
            System.out.println("Total do Pedido: R$ " + p.calcularTotal());
            System.out.println("-".repeat(28));
        }
    }

    public void listarPedidosPorCliente(int idCliente) { //Lista os pedidos de um cliente específico
        for (Pedido p : list) {
            if (p.getId() == idCliente) {
                System.out.println("-".repeat(28));
                System.out.println("ID do Cliente: " + p.getId());
                System.out.println("Nome do Cliente: " + p.getCliente().getNome());
                System.out.println("-".repeat(28));
            }
        }
    }
}
