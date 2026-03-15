package ex03;

public class Cliente {
    String nome;
    String identificacao;
    String endereco;

    public void definirValores(String nome, String identificacao, String endereco) {
        this.nome = nome;
        this.identificacao = identificacao;
        this.endereco = endereco;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Identificação: " + identificacao);
        System.out.println("Endereço: " + endereco);
    }
}