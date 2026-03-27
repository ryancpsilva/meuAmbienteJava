import java.util.Scanner;

public class Pedido {
    Scanner sc = new Scanner(System.in);
    Cliente cliente = new Cliente();
    int id;

    Pedido(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente não encontrado! O pedido não pode ser criado sem cliente cadastrado.");
            return;
        }
        this.id = cliente.getId();
        this.cliente = cliente;
    }

    public void cadastrarPedido() { // Cria novo item e adiciona ao pedido, associando o pedido ao cliente
        try {
            Item item = new Item();
            String nome = sc.nextLine();
            if (nome.trim().isEmpty()) { // Verifica se o nome é vazio e pergunta se deseja continuar
                System.out.println("Nome vazio! Deseja continuar? (S/N)");
                char resposta = sc.nextLine().toLowerCase().charAt(0);
                if (resposta == 's') {//Cadastra o item como desconhecido

                } else {
                    System.out.println("Item não cadastrado!");
                }
            }
            item.setNome(nome);
            //IMPLEMENTAR A LÓGICA PARA ADICIONAR O ITEM AO PEDIDO E ASSOCIAR O PEDIDO AO CLIENTE
            System.out.println("Pedido cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pedido: " + e.getMessage());
        }
    }

}