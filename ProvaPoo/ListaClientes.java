import java.util.ArrayList;
import java.util.Scanner;

class ListaClientes {
    private ArrayList<Cliente> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public boolean cadastrarCliente() { // Cadastra um cliente, retorna true se for cadastrado com sucesso, false se
                                        // ocorrer algum erro
        try {
            Cliente cliente = new Cliente();
            cliente.setId(list.size() + 1);
            String nome = sc.nextLine();
            if (nome.trim().isEmpty()) { // Verifica se o nome é vazio e pergunta se deseja continuar
                System.out.println("Nome vazio! Deseja continuar? (S/N)");
                char resposta = sc.nextLine().toLowerCase().charAt(0);
                if (resposta == 's') { // Se o usuário quiser continuar, cadastra o cliente com nome "Desconhecido"
                    list.add(cliente);
                    return true;
                } else {
                    System.out.println("Cliente não cadastrado!");
                    return false;
                }
            }
            cliente.setNome(nome);
            list.add(cliente);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Cliente getClienteById(int id) { // Busca cliente por ID, retorna null se não encontrar
        id--;
        if (id < 0 || id >= list.size()) {
            return null;
        }
        if (list.contains(list.get(id))) {
            return list.get(id);
        }
        return null;
    }

    public void listarClientes() { // Lista os clientes cadastrados
        for (Cliente c : list) {
            System.out.println("-".repeat(28));
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("-".repeat(28));
        }
    }

    public int getSize() { // Retorna o número de clientes cadastrados
        return list.size();
    }
}