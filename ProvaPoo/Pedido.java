public class Pedido {
    Cliente cliente = new Cliente();
    int id;

    Pedido(Cliente cliente){
        if (cliente == null) {
            System.out.println("Cliente não encontrado! O pedido não pode ser criado sem cliente cadastrado.");
            return;
        }
        this.id = cliente.getId();
        this.cliente = cliente;
    }
}