package ex04;

class ItemPedido {
    String nomeProduto;
    int quantidade;
    double valorUnitario;

    public void mostrarItem() {
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor Unitario: " + valorUnitario);
    }
}