package ex04;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

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

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {

            oos.writeObject(estado);

            System.out.println("Jogo salvo com sucesso!");

        } catch (java.io.IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public EstadoJogo carregarJogo(String arquivo) {

        try (ObjectInputStream ois = new ObjectInputStream( new FileInputStream(arquivo))) {

            EstadoJogo estado = (EstadoJogo) ois.readObject();

            System.out.println("Jogo carregado com sucesso!");

            return estado;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
            return null;
        }
    }
}