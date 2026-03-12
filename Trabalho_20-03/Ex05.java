public class Ex05 {    
    public static void main(String[] args) {
        
        ItemPedido1 item = new ItemPedido1();
        
        item.nomeProduto = "Arroz";
        item.quantidade = 2;
        item.valorUnitario = 20.0;
        
        item.mostrarItem();
        
        System.out.println("Total do item: " + item.calcularTotal());        
    }
}

class ItemPedido1{
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