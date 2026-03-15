package ex04;

public class Main {
    public static void main(String[] args){
      ItemPedido item = new ItemPedido();
      item.nomeProduto = "Macarrão";
      item.quantidade = 7;
      item.valorUnitario = 45.0;
      item.mostrarItem();
    }
}