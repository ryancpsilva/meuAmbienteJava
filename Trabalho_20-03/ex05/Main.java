package ex05;

public class Main {
    public static void main(String[] args) {

        ItemPedido1 item = new ItemPedido1();

        item.nomeProduto = "Arroz";
        item.quantidade = 2;
        item.valorUnitario = 20.0;

        item.mostrarItem();

        System.out.println("Total do item: " + item.calcularTotal());
    }
}
