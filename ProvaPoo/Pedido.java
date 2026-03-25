public class Pedido {
    Cliente cliente = new Cliente();

    Pedido(Cliente cliente){
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        this.cliente = cliente;
    }
}