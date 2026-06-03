import java.io.Serializable;

public class Competidor implements Serializable {
    private String nickname;
    private int score;
    private int movimentos;

    public Competidor(String nickname) {
        if (nickname == null || nickname.trim().isEmpty()) {
            this.nickname = "Jogador Anônimo";
        } else {
            this.nickname = nickname;
        }
        this.score = 0;
        this.movimentos = 0;
    }

    public Competidor() {
        this.nickname = "Jogador Anônimo";
        this.score = 0;
        this.movimentos = 0;
    }

    public String getNickname() { return nickname; }
    public int getScore() { return score; }
    public int getMovimentos() { return movimentos; }

    public void computarAcerto(int pontosGanhos) {
        this.score += pontosGanhos;
    }

    public void adicionarMovimento() {
        this.movimentos++;
    }
}