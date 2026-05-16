import java.io.Serializable;

public class Jogador implements Serializable {
    private String nome;
    private int pontuacao;
    private int tentativas;

    // Construtor
    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.tentativas = 0;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void adicionarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void registrarTentativa() {
        this.tentativas++;
    }

    @Override
    public String toString() {
        return "Jogador: " + nome + " | Tentativas: " + tentativas + " | Pontos: " + pontuacao;
    }
}