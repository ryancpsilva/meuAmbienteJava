public class Item { //Classe para representar um item do pedido
    private String nome;
    private int quantidade;
    private double preco;

    public Item() {
        this("Item desconhecido", 0);
    }

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    
}
