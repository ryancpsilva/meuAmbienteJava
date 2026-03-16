package ex10;

class Item {
    String nomeProduto;
    int quantidade;
    double valorUnitario;

    public void mostrarItem() {
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor Unitario: " + valorUnitario);
    }

    public double calcularTotal() {
        return quantidade * valorUnitario;
    }

}