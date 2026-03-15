package ex08;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente();
        c1.nome = "Ryan";
        c1.CPF = "123456";
        c1.endereco = "Rio de Janeiro";

        ListaClientes lista = new ListaClientes(c1);

        lista.cadastrarCliente();

        System.out.println(lista.listarClientes());

    }
}

