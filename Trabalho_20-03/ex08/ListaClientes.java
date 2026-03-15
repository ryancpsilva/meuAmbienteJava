package ex08;

import java.util.ArrayList;

class ListaClientes {
    ArrayList<Cliente> list = new ArrayList<>();
    Cliente cliente = new Cliente();

    ListaClientes(Cliente cliente) {
        this.cliente = cliente;
    }

    boolean cadastrarCliente() {
        try {
            list.add(cliente);
            return true;
        } catch (Exception err) {

            return false;
        }
    }

    String listarClientes() {
        String resultado = "";
        for (Cliente cl : list) {
            resultado += "Nome: " + cl.nome + "\n"
                    + "CPF: " + cl.CPF + "\n"
                    + "Endereço: " + cl.endereco + "\n\n";
        }
        return resultado;
    }
}