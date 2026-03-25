import java.util.ArrayList;
import java.util.Scanner;

class ListaClientes {
    ArrayList<Cliente> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    boolean cadastrarCliente() {
        try {
            Cliente cliente = new Cliente("", 0);
            System.out.print("Digite o nome do cliente: ");
            cliente.setNome(sc.nextLine());
            cliente.setId(list.size() + 1);
            list.add(cliente);
            System.out.print("Cliente cadastrado com sucesso!");
            return true;
        } catch (Exception err) {
            System.out.print("Erro ao cadastrar cliente!");
            return false;
        }
    }

    public void listarClientes() {
        for (Cliente c : list) {
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
        }
    }
}