import java.io.Serializable;

public class PecaTabuleiro implements ElementoVisivel, Serializable {
    private String iconeOculto;
    private boolean faceParaCima;

    public PecaTabuleiro(String icone) {
        this.iconeOculto = icone;
        this.faceParaCima = false;
    }

    @Override
    public String obterAparencia() {
        return faceParaCima ? " " + iconeOculto + " " : "[#]";
    }

    @Override
    public String buscarSimbolo() {
        return this.iconeOculto;
    }

    @Override
    public boolean estaExposta() {
        return this.faceParaCima;
    }

    @Override
    public void mudarStatusExposicao(boolean status) {
        this.faceParaCima = status;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }
}