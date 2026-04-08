import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    Scanner sc = new Scanner(System.in);
    private Cliente cliente = new Cliente();
    private int id;
    private ArrayList<Item> itens = new ArrayList<>();

    Pedido(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente não encontrado! O pedido não pode ser criado sem cliente cadastrado.");
            return;
        }
        this.id = cliente.getId();
        this.cliente = cliente;
    }

    public boolean cadastrarPedido() { // Cria novo item e adiciona ao pedido, associando o pedido ao cliente
        try {
            Item item = new Item();
            System.out.print("Digite o nome do item: ");
            String nome = sc.nextLine();
            System.out.print("Digite a quantidade do item: ");
            int quantidade = sc.nextInt();
            sc.nextLine(); // limpar buffer
            System.out.print("Digite o preço do item: ");
            double preco = sc.nextDouble();
            sc.nextLine(); // limpar buffer

            if (quantidade <= 0) { // Verifica se a quantidade é válida
                System.out.println("Quantidade inválida! O item não pode ser cadastrado.");
                return false;
            }

            if (nome.trim().isEmpty()) { // Verifica se o nome é vazio e pergunta se deseja continuar
                System.out.println("Nome vazio! Não é possível cadastrar um item sem nome.");
                return false;
            }

            if (preco <= 0) {
                System.out.println("Preço inválido! O item não pode ser cadastrado.");
                return false;
            }

            item.setNome(nome);
            item.setQuantidade(quantidade);
            item.setPreco(preco);
            itens.add(item);

            System.out.println("Pedido cadastrado com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pedido: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public int getId() {
        return id;
    }

    // NOVO MÉTODO: Calcula o total multiplicando a quantidade de cada item pelo seu
    // preço
    public double calcularTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += (item.getQuantidade() * item.getPreco());
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }
}