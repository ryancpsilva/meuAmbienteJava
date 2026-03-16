package ex10;

class Cliente {
    String nome;
    String CPF;
    String endereco;
    public void mostrarCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Endereço: " + endereco);
    }
}