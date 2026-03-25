import java.util.ArrayList;
import java.util.Scanner;

class ListaClientes {
    private ArrayList<Cliente> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public boolean cadastrarCliente() {
        try {
            Cliente cliente = new Cliente();
            cliente.setNome(sc.nextLine());
            cliente.setId(list.size() + 1);
            if (cliente.getNome().trim().isEmpty()) {
                System.out.println("Nome inválido!");
                return false;
            }
            list.add(cliente);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Cliente getClienteById (int id) {
        id--;
        if (id < 0 || id >= list.size()) {
            return null;
        }
        if (list.contains(list.get(id))) {
            return list.get(id);
        }
        return null;
    }

    public void listarClientes() {
        for (Cliente c : list) {
            System.out.println("-".repeat(28));
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("-".repeat(28));
        }
    }

    public int getSize() {
        return list.size();
    }
}