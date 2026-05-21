package ex04;

import java.io.Serializable;

public class EstadoJogo implements Serializable {

    private Tabuleiro tabuleiro;
    private int tentativas;

    public EstadoJogo() {
    }

    public EstadoJogo(Tabuleiro tabuleiro, int tentativas) {
        this.tabuleiro = tabuleiro;
        this.tentativas = tentativas;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void salvarJogo(Tabuleiro tabuleiro, int tentativas, String arquivo) {

        EstadoJogo estado = new EstadoJogo(tabuleiro, tentativas);

        try (java.io.ObjectOutputStream oos =
                     new java.io.ObjectOutputStream(
                             new java.io.FileOutputStream(arquivo))) {

            oos.writeObject(estado);

            System.out.println("Jogo salvo com sucesso!");

        } catch (java.io.IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public EstadoJogo carregarJogo(String arquivo) {

        try (java.io.ObjectInputStream ois =
                     new java.io.ObjectInputStream(
                             new java.io.FileInputStream(arquivo))) {

            EstadoJogo estado = (EstadoJogo) ois.readObject();

            System.out.println("Jogo carregado com sucesso!");

            return estado;

        } catch (java.io.IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
            return null;
        }
    }
}