package ex05;

public class Main {
    public static void main(String[] args) {

        ItemPedido item = new ItemPedido();

        item.nomeProduto = "Arroz";
        item.quantidade = 2;
        item.valorUnitario = 20.0;

        item.mostrarItem();

        System.out.println("Total do item: " + item.calcularTotal());
    }
}
