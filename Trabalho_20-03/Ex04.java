public class Ex04 {
    public static void main(String[] args){
      ItemPedido item = new ItemPedido();
      item.nomeProduto = "Macarrão";
      item.quantidade = 7;
      item.valorUnitario = 45.0;
      item.mostrarItem();
    }
}
class ItemPedido{
    String nomeProduto;
    int quantidade;
    double valorUnitario;
    public void mostrarItem()  {
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor Unitario: " + valorUnitario);  
    } 
}