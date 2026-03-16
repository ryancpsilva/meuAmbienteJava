package ex10;

import java.util.ArrayList;

class ListaClientes {
    ArrayList<Cliente> list = new ArrayList<>();

    boolean cadastrarCliente(Cliente cliente) {
        try {
            list.add(cliente);
            return true;
        } catch (Exception err) {

            return false;
        }
    }

    void listarClientes() {
        for (Cliente cl : list) {
            System.out.println("-".repeat(15));                    
            cl.mostrarCliente();
            System.out.println("-".repeat(15));                    
        }
    }
}